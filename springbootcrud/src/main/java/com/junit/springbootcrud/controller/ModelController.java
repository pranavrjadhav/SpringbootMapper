package com.junit.springbootcrud.controller;

import com.junit.springbootcrud.Dto.Modeldto;
import com.junit.springbootcrud.services.Modelservices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class ModelController {

    @Autowired
    private Modelservices modelservices;


    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/all")
    ResponseEntity<List<Modeldto>> getall(){
        return new ResponseEntity<>(modelservices.findall(), HttpStatus.ACCEPTED);
    }

    @PostMapping
    ResponseEntity<Modeldto> savedata(@RequestBody Modeldto modeldto){
        return new ResponseEntity<>(modelservices.save(modeldto),HttpStatus.CREATED);
    }

    @GetMapping("/{pid}")
    ResponseEntity<Modeldto> findbyid(@PathVariable Integer pid){
        return new ResponseEntity<>(modelservices.findbyId(pid),HttpStatus.OK);
    }
//
    @PutMapping("/{pid}")
    ResponseEntity<Modeldto> update(@PathVariable Integer pid , @RequestBody Modeldto modeldto){
         Modeldto updatedPerson = modelservices.updatebyid(pid, modeldto);
        if (updatedPerson == null) {
            // Return a not found response if update fails
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedPerson,HttpStatus.UPGRADE_REQUIRED);
    }

    @DeleteMapping("/{pid}")
    ResponseEntity<String> deletebyid(@PathVariable Integer pid){
        modelservices.deletebyid(pid);
        return ResponseEntity.ok("record deleted seucefully");
    }

}

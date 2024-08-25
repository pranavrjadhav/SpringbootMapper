package com.junit.springbootcrud.services;

import com.junit.springbootcrud.Dto.Modeldto;
import com.junit.springbootcrud.Mapper.PersonMapper;
import com.junit.springbootcrud.execption.PersonNotFoundException;
import com.junit.springbootcrud.model.Person;
import com.junit.springbootcrud.repo.Modelrepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class Modelservices implements repoimpl {

    @Autowired
    private Modelrepo modelrepo;

    private  final PersonMapper personMapper = PersonMapper.INSTANCE;

//    @Autowired
//    private ModelMapper modelMapper;

    @Override
    public List<Modeldto> findall() {
        List<Person> persons = modelrepo.findAll();
        System.out.println("Retrieved Persons: " + persons);

//        List<Person> personList = modelrepo.findAll();
        return persons.stream()
                .map(personMapper::modeltodto)
                .collect(Collectors.toList());
    }


    @Override
    public Modeldto findbyId(Integer pid) {
        Person person = modelrepo.findById(pid)
                .orElseThrow(() -> new PersonNotFoundException("Person not found with id: " + pid));
//        Modeldto modeldto1 = modelMapper.map(person,Modeldto.class);

        Modeldto modeldto1 = personMapper.modeltodto(person);
        return modeldto1;
    }
//
//

    @Override
    public Modeldto updatebyid(Integer pid, Modeldto modeldto) {
        Person existingPerson = (modelrepo.findById(pid).orElseThrow(() -> new PersonNotFoundException("Person not found with id: " + pid)));
        // Update the fields with the provided values
        if (modeldto.getPname() != null) {
            existingPerson.setPname(modeldto.getPname());
        }
        if (modeldto.getPaddress() != null) {
            existingPerson.setPaddress(modeldto.getPaddress());
        }

        Person person = modelrepo.save(existingPerson);
//        Modeldto modeldto1 = modelMapper.map(person,Modeldto.class);

        Modeldto modeldto1 = personMapper.modeltodto(person);
        return modeldto1;
    }

    @Override
    public void deletebyid(Integer pid) {
        Person person2 = (modelrepo.findById(pid).orElseThrow(() -> new PersonNotFoundException("Person foundf with not record")));
        modelrepo.deleteById(pid);
    }

    @Override
    public Modeldto save(Modeldto modeldto) {
//        Person person = modelMapper.map(modeldto, Person.class);   modelmapper(dto to person)
        Person person = personMapper.dtotoperson(modeldto);
//        Modeldto modeldto1 = modelMapper.map(modelrepo.save(person),Modeldto.class);  modelmapper(person to dto)
        Modeldto modeldto1 = personMapper.modeltodto(person);
        return modeldto1;
    }



}

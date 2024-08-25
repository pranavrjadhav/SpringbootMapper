package com.junit.springbootcrud.services;

import com.junit.springbootcrud.Dto.Modeldto;
import com.junit.springbootcrud.model.Person;

import java.util.*;

public interface repoimpl {
//
    List<Modeldto> findall();
//
    Modeldto findbyId(Integer pid);
//
    Modeldto updatebyid(Integer pid , Modeldto modeldto);
//
    void deletebyid(Integer pid);

    Modeldto save(Modeldto modeldto);
}

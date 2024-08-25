package com.junit.springbootcrud.repo;

import com.junit.springbootcrud.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Modelrepo extends JpaRepository<Person,Integer>{
}

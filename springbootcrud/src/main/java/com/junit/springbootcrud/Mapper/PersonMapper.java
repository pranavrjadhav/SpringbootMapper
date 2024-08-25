package com.junit.springbootcrud.Mapper;

import com.junit.springbootcrud.Dto.Modeldto;
import com.junit.springbootcrud.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

   PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

   Modeldto modeltodto(Person person);

   Person dtotoperson(Modeldto modeldto);
}

package com.junit.springbootcrud.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.stream.DoubleStream;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Modeldto {

    private Integer pid;
    private String pname;
    private String paddress;

}

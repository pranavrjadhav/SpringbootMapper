package com.junit.springbootcrud.model;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer pid;
    @Column(name="person_name")
    private String pname;
    @Column(name = "person_address")
    private String paddress;
}

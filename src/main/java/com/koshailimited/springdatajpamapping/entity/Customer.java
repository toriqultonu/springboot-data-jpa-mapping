package com.koshailimited.springdatajpamapping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String gender;
}

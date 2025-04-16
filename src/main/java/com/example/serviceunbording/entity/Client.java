package com.example.serviceunbording.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "clients")
public class Client {
    //id

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String firstName;
    private String serialNumber;
    private String inn;
    private String city;

    @OneToMany(mappedBy = "client")
    private Set<Recording> recordings = new HashSet<Recording>();

}

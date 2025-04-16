package com.example.serviceunbording.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "office_banks")
public class OfficeBank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String city;

    @OneToMany(mappedBy = "officeBank")
    private Set<Recording> recordings = new HashSet<>();


}

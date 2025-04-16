package com.example.serviceunbording.repository;


import com.example.serviceunbording.entity.OfficeBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeBankRepository extends JpaRepository<OfficeBank, Long> {
}

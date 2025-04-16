package com.example.serviceunbording.service;

import com.example.serviceunbording.entity.OfficeBank;
import com.example.serviceunbording.repository.OfficeBankRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//add service OfficeBank
@Service
@AllArgsConstructor
public class OfficeBankService {
    private OfficeBankRepository officeBankRepository;

    public OfficeBank addBank(OfficeBank officeBank) {
        return officeBankRepository.save(officeBank);
    }

    public Optional<OfficeBank> findBankById(Long id) {
        return officeBankRepository.findById(id);
    }


    public List<OfficeBank> findAllBanks() {
        return officeBankRepository.findAll();
    }


    public OfficeBank updateBank(Long id, OfficeBank officeBank) {
        return officeBankRepository.findById(id).map(officeBank1 -> {
            officeBank1.setName(officeBank.getName());
            return officeBankRepository.save(officeBank1);
        }).orElseThrow(()-> new RuntimeException("Office bank not found"));
    }


    public void deleteBank(Long id) {
        officeBankRepository.deleteById(id);

    }

}

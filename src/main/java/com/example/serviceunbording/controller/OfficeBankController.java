package com.example.serviceunbording.controller;

import com.example.serviceunbording.entity.OfficeBank;
import com.example.serviceunbording.service.OfficeBankService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//add controller OfficeBank
@RestController
@RequestMapping("/office_bank")
@AllArgsConstructor
public class OfficeBankController {
    private OfficeBankService officeBankService;


    @PostMapping
    public ResponseEntity<OfficeBank> createOfficeBank(@RequestBody OfficeBank officeBank) {
        OfficeBank bank = officeBankService.addBank(officeBank);
        return ResponseEntity.status(HttpStatus.CREATED).body(bank);
    }

    @GetMapping
    public ResponseEntity<List<OfficeBank>> getAllOfficeBanks() {
        List<OfficeBank> getBank = officeBankService.findAllBanks();
        return ResponseEntity.status(HttpStatus.CREATED).body(getBank);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfficeBank> getOfficeBankById(@PathVariable Long id) {
        return officeBankService.findBankById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfficeBank> updateOfficeBank(@PathVariable Long id, @RequestBody OfficeBank officeBank) {
        try {
            OfficeBank bankUpdate = officeBankService.updateBank(id, officeBank);
            return ResponseEntity.ok(bankUpdate);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOfficeBank(@PathVariable Long id) {
        officeBankService.deleteBank(id);
        return ResponseEntity.noContent().build();
    }
}

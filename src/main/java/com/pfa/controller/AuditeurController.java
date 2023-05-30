package com.pfa.controller;
import com.pfa.exception.AuditeurNotFoundException;

import com.pfa.model.Auditeur;
import com.pfa.repository.AuditeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class AuditeurController {

    @Autowired
    private AuditeurRepository AuditeurRepository;

    @PostMapping("/Auditeur")
    Auditeur newAuditeur(@RequestBody Auditeur newAuditeur) {
        return AuditeurRepository.save(newAuditeur);
    }

    @GetMapping("/Auditeurs")
    List<Auditeur> getAllAuditeurs() {
        return AuditeurRepository.findAll();
    }

    @GetMapping("/Auditeur/{id}")
    Auditeur getAuditeurById(@PathVariable Integer id) {
        return AuditeurRepository.findById(id)
                .orElseThrow(() -> new AuditeurNotFoundException(id));
    }

    @PutMapping("/Auditeur/{id}")
    Auditeur updateAuditeur(@RequestBody Auditeur newAuditeur, @PathVariable Integer id) {
        return AuditeurRepository.findById(id)
                .map(Auditeur -> {
                    Auditeur.setName(newAuditeur.getName());
                    Auditeur.setName(newAuditeur.getName());
                    
                    return AuditeurRepository.save(Auditeur);
                }).orElseThrow(() -> new AuditeurNotFoundException(id));
    }

    @DeleteMapping("/Auditeur/{id}")
    String deleteAuditeur(@PathVariable Integer id){
        if(!AuditeurRepository.existsById(id)){
            throw new AuditeurNotFoundException(id);
        }
        AuditeurRepository.deleteById(id);
        return  "Auditeur with id "+id+" has been deleted success.";
    }



}
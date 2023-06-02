package com.pfa.controller;

import com.pfa.model.Audit;
import com.pfa.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class AuditController {

    @Autowired
    private AuditRepository auditRepository;

    @PostMapping("/audits")
    public Audit createAudit(@RequestBody Audit audit) {
        return auditRepository.save(audit);
    }

    @GetMapping("/audits")
    public List<Audit> getAllAudits() {
        return auditRepository.findAll();
    }

    @GetMapping("/audits/{id}")
    public Audit getAuditById(@PathVariable String id) {
        return auditRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @PutMapping("/audits/{id}")
    public Audit updateAudit(@PathVariable String id, @RequestBody Audit updatedAudit) {
        Audit audit = auditRepository.findById(Integer.valueOf(id)).orElse(null);
        if (audit != null) {
            audit.setName(updatedAudit.getName());
            audit.setDescription(updatedAudit.getDescription());
            audit.setStartDate(updatedAudit.getStartDate());
            audit.setEndDate(updatedAudit.getEndDate());
            audit.setProcess(updatedAudit.getProcess());
            audit.setSite(updatedAudit.getSite());
            return auditRepository.save(audit);
        }
        return null;
    }

    @DeleteMapping("/audits/{id}")
    public String deleteAudit(@PathVariable String id) {
        if (auditRepository.existsById(Integer.valueOf(id))) {
            auditRepository.deleteById(Integer.valueOf(id));
            return "Audit with id " + id + " has been deleted successfully.";
        }
        return "Audit not found.";
    }
}

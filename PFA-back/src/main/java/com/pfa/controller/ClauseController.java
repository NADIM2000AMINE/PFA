package com.pfa.controller;


import com.pfa.model.Clause;
import com.pfa.model.Audit;
import com.pfa.repository.ClauseRepository;
import com.pfa.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ClauseController {

    @Autowired
    private ClauseRepository clauseRepository;

    @Autowired
    private AuditRepository auditRepository;

    @PostMapping("/clauses")
    public Clause createClause(@RequestBody Clause clause) {
        return clauseRepository.save(clause);
    }

    @GetMapping("/clauses")
    public List<Clause> getAllClauses() {
        return clauseRepository.findAll();
    }

    @GetMapping("/clauses/{id}")
    public Clause getClauseById(@PathVariable String id) {
        return clauseRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @PutMapping("/clauses/{id}")
    public Clause updateClause(@PathVariable String id, @RequestBody Clause clause) {
        Clause existingClause = clauseRepository.findById(Integer.valueOf(id)).orElse(null);
        if (existingClause != null) {
            existingClause.setName(clause.getName());
            existingClause.setRequirements(clause.getRequirements());
            existingClause.setStandard(clause.getStandard());
            existingClause.setExigenceDescription(clause.getExigenceDescription());
            existingClause.setStatus(clause.getStatus());
            return clauseRepository.save(existingClause);
        }
        return null;
    }

    @DeleteMapping("/clauses/{id}")
    public String deleteClause(@PathVariable String id) {
        if (clauseRepository.existsById(Integer.valueOf(id))) {
            clauseRepository.deleteById(Integer.valueOf(id));
            return "Clause with id " + id + " has been deleted successfully.";
        }
        return "Clause not found.";
    }

    @GetMapping("/clauses/audit/{auditId}")
    public List<Clause> getClausesByAuditId(@PathVariable String auditId) {
        Audit audit = auditRepository.findById(Integer.valueOf(auditId)).orElse(null);
        if (audit != null) {
            return clauseRepository.findByAudit(audit);
        }
        return null;
    }
}

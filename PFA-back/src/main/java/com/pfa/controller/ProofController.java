package com.pfa.controller;
import com.pfa.model.Proof;
import com.pfa.repository.ProofRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProofController {

    @Autowired
    private ProofRepository proofRepository;

    @PostMapping("/proof")
    public Proof createProof(@RequestBody Proof proof) {
        return proofRepository.save(proof);
    }

    @GetMapping("/proof")
    public List<Proof> getAllProof() {
        return proofRepository.findAll();
    }

    @GetMapping("/proof/{id}")
    public Proof getProofById(@PathVariable String id) {
        return proofRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @PutMapping("/proof/{id}")
    public Proof updateProof(@PathVariable String id, @RequestBody Proof updatedProof) {
        Proof proof = proofRepository.findById(Integer.valueOf(id)).orElse(null);
        if (proof != null) {
            proof.setDescription(updatedProof.getDescription());
            proof.setResult(updatedProof.getResult());
            return proofRepository.save(proof);
        }
        return null;
    }

    @DeleteMapping("/proof/{id}")
    public String deleteProof(@PathVariable String id) {
        if (proofRepository.existsById(Integer.valueOf(id))) {
            proofRepository.deleteById(Integer.valueOf(id));
            return "Proof with id " + id + " has been deleted successfully.";
        }
        return "Proof not found.";
    }
}

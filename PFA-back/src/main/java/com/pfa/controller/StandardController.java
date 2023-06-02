package com.pfa.controller;
import com.pfa.model.Standard;
import com.pfa.repository.StandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class StandardController {

    @Autowired
    private StandardRepository standardRepository;

    @PostMapping("/standard")
    public Standard createStandard(@RequestBody Standard standard) {
        return standardRepository.save(standard);
    }

    @GetMapping("/standard")
    public List<Standard> getAllStandards() {
        return standardRepository.findAll();
    }

    @GetMapping("/standard/{id}")
    public Standard getStandardById(@PathVariable String id) {
        return standardRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @PutMapping("/standard/{id}")
    public Standard updateStandard(@PathVariable String id, @RequestBody Standard updatedStandard) {
        Standard standard = standardRepository.findById(Integer.valueOf(id)).orElse(null);
        if (standard != null) {
            standard.setName(updatedStandard.getName());
            standard.setDescription(updatedStandard.getDescription());
            return standardRepository.save(standard);
        }
        return null;
    }

    @DeleteMapping("/standard/{id}")
    public String deleteStandard(@PathVariable String id) {
        if (standardRepository.existsById(Integer.valueOf(id))) {
            standardRepository.deleteById(Integer.valueOf(id));
            return "Standard with id " + id + " has been deleted successfully.";
        }
        return "Standard not found.";
    }
}

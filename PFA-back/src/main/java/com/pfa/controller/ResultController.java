package com.pfa.controller;
import com.pfa.model.Result;
import com.pfa.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ResultController {

    @Autowired
    private ResultRepository resultRepository;

    @PostMapping("/result")
    public Result createResult(@RequestBody Result result) {
        return resultRepository.save(result);
    }

    @GetMapping("/result")
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    @GetMapping("/result/{id}")
    public Result getResultById(@PathVariable String id) {
        return resultRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @PutMapping("/result/{id}")
    public Result updateResult(@PathVariable String id, @RequestBody Result updatedResult) {
        Result result = resultRepository.findById(Integer.valueOf(id)).orElse(null);
        if (result != null) {
            result.setEtat(updatedResult.getEtat());
            result.setAudit(updatedResult.getAudit());
            return resultRepository.save(result);
        }
        return null;
    }

    @DeleteMapping("/result/{id}")
    public String deleteResult(@PathVariable String id) {
        if (resultRepository.existsById(Integer.valueOf(id))) {
            resultRepository.deleteById(Integer.valueOf(id));
            return "Result with id " + id + " has been deleted successfully.";
        }
        return "Result not found.";
    }
}

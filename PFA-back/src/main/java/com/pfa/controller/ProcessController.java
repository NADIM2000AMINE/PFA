package com.pfa.controller;
import com.pfa.model.Process;
import com.pfa.repository.ProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProcessController {

    @Autowired
    private ProcessRepository processRepository;

    @PostMapping("/process")
    public Process createProcess(@RequestBody Process process) {
        return processRepository.save(process);
    }

    @GetMapping("/process")
    public List<Process> getAllProcess() {
        return processRepository.findAll();
    }

    @GetMapping("/process/{id}")
    public Process getProcessById(@PathVariable String id) {
        return processRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @PutMapping("/process/{id}")
    public Process updateProcess(@PathVariable String id, @RequestBody Process updatedProcess) {
        Process process = processRepository.findById(Integer.valueOf(id)).orElse(null);
        if (process != null) {
            process.setName(updatedProcess.getName());
            process.setDescription(updatedProcess.getDescription());
            process.setSite(updatedProcess.getSite());
            process.setProcessManager(updatedProcess.getProcessManager());
            return processRepository.save(process);
        }
        return null;
    }

    @DeleteMapping("/process/{id}")
    public String deleteProcess(@PathVariable String id) {
        if (processRepository.existsById(Integer.valueOf(id))) {
            processRepository.deleteById(Integer.valueOf(id));
            return "Process with id " + id + " has been deleted successfully.";
        }
        return "Process not found.";
    }
}

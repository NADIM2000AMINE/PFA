package com.pfa.controller;
import com.pfa.model.File;
import com.pfa.repository.FileRepository;
import com.pfa.repository.ProofRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class FileController {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private ProofRepository proofRepository;

    @PostMapping("/files")
    public File createFile(@RequestBody File file) {
        return fileRepository.save(file);
    }

    @GetMapping("/files")
    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    @GetMapping("/files/{id}")
    public File getFileById(@PathVariable String id) {
        return fileRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @PutMapping("/files/{id}")
    public File updateFile(@PathVariable String id, @RequestBody File updatedFile) {
        File file = fileRepository.findById(Integer.valueOf(id)).orElse(null);
        if (file != null) {
            file.setName(updatedFile.getName());
            file.setContent(updatedFile.getContent());
            file.setProof(updatedFile.getProof());
            return fileRepository.save(file);
        }
        return null;
    }

    @DeleteMapping("/files/{id}")
    public String deleteFile(@PathVariable String id) {
        if (fileRepository.existsById(Integer.valueOf(id))) {
            fileRepository.deleteById(Integer.valueOf(id));
            return "File with id " + id + " has been deleted successfully.";
        }
        return "File not found.";
    }
}


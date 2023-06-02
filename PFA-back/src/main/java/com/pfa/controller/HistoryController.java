package com.pfa.controller;
import com.pfa.model.History;
import com.pfa.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class HistoryController {

    @Autowired
    private HistoryRepository historyRepository;

    @PostMapping("/history")
    public History createHistory(@RequestBody History history) {
        return historyRepository.save(history);
    }

    @GetMapping("/history")
    public List<History> getAllHistory() {
        return historyRepository.findAll();
    }

    @GetMapping("/history/{id}")
    public History getHistoryById(@PathVariable String id) {
        return historyRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @PutMapping("/history/{id}")
    public History updateHistory(@PathVariable String id, @RequestBody History updatedHistory) {
        History history = historyRepository.findById(Integer.valueOf(id)).orElse(null);
        if (history != null) {
            history.setUserId(updatedHistory.getUserId());
            history.setAffected(updatedHistory.getAffected());
            history.setContent(updatedHistory.getContent());
            return historyRepository.save(history);
        }
        return null;
    }

    @DeleteMapping("/history/{id}")
    public String deleteHistory(@PathVariable String id) {
        if (historyRepository.existsById(Integer.valueOf(id))) {
            historyRepository.deleteById(Integer.valueOf(id));
            return "History with id " + id + " has been deleted successfully.";
        }
        return "History not found.";
    }
}

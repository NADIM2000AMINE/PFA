package com.pfa.controller;
import com.pfa.model.Action;
import com.pfa.model.Audit;
import com.pfa.repository.ActionRepository;
import com.pfa.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ActionController {

    @Autowired
    private ActionRepository actionRepository;

    @Autowired
    private AuditRepository auditRepository;

    @PostMapping("/actions")
    public Action createAction(@RequestBody Action action) {
        return actionRepository.save(action);
    }

    @GetMapping("/actions")
    public List<Action> getAllActions() {
        return actionRepository.findAll();
    }

    @GetMapping("/actions/{id}")
    public Action getActionById(@PathVariable String id) {
        return actionRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @GetMapping("/actions/audit/{auditId}")
    public List<Action> getActionsByAuditId(@PathVariable String auditId) {
        Audit audit = auditRepository.findById(Integer.valueOf(auditId)).orElse(null);
        if (audit != null) {
            return actionRepository.findByAudit(audit);
        } else {
            return null;
        }
    }

    @PutMapping("/actions/{id}")
    public Action updateAction(@RequestBody Action updatedAction, @PathVariable String id) {
        Action action = actionRepository.findById(Integer.valueOf(id)).orElse(null);
        if (action != null) {
            action.setName(updatedAction.getName());
            action.setDescription(updatedAction.getDescription());
            action.setResult(updatedAction.getResult());
            return actionRepository.save(action);
        } else {
            return null;
        }
    }

    @DeleteMapping("/actions/{id}")
    public String deleteAction(@PathVariable String id) {
        if (actionRepository.existsById(Integer.valueOf(id))) {
            actionRepository.deleteById(Integer.valueOf(id));
            return "Action with id " + id + " has been deleted successfully.";
        } else {
            return "Action with id " + id + " does not exist.";
        }
    }
}


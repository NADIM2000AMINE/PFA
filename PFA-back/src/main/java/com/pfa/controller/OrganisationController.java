package com.pfa.controller;
import com.pfa.model.Organisation;
import com.pfa.repository.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class OrganisationController {

    @Autowired
    private OrganisationRepository organisationRepository;

    @PostMapping("/organisation")
    public Organisation createOrganisation(@RequestBody Organisation organisation) {
        return organisationRepository.save(organisation);
    }

    @GetMapping("/organisation")
    public List<Organisation> getAllOrganisation() {
        return organisationRepository.findAll();
    }

    @GetMapping("/organisation/{id}")
    public Organisation getOrganisationById(@PathVariable String id) {
        return organisationRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @PutMapping("/organisation/{id}")
    public Organisation updateOrganisation(@PathVariable String id, @RequestBody Organisation updatedOrganisation) {
        Organisation organisation = organisationRepository.findById(Integer.valueOf(id)).orElse(null);
        if (organisation != null) {
            organisation.setName(updatedOrganisation.getName());
            organisation.setDescription(updatedOrganisation.getDescription());
            organisation.setTurnover(updatedOrganisation.getTurnover());
            organisation.setAddress(updatedOrganisation.getAddress());
            organisation.setEmployees(updatedOrganisation.getEmployees());
            organisation.setItManager(updatedOrganisation.getItManager());
            organisation.setSites(updatedOrganisation.getSites());
            return organisationRepository.save(organisation);
        }
        return null;
    }

    @DeleteMapping("/organisation/{id}")
    public String deleteOrganisation(@PathVariable String id) {
        if (organisationRepository.existsById(Integer.valueOf(id))) {
            organisationRepository.deleteById(Integer.valueOf(id));
            return "Organisation with id " + id + " has been deleted successfully.";
        }
        return "Organisation not found.";
    }
}

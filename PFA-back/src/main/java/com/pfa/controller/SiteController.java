package com.pfa.controller;

import com.pfa.model.Site;
import com.pfa.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class SiteController {

    @Autowired
    private SiteRepository siteRepository;

    @PostMapping("/site")
    public Site createSite(@RequestBody Site site) {
        return siteRepository.save(site);
    }

    @GetMapping("/site")
    public List<Site> getAllSites() {
        return siteRepository.findAll();
    }

    @GetMapping("/site/{id}")
    public Site getSiteById(@PathVariable String id) {
        return siteRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @PutMapping("/site/{id}")
    public Site updateSite(@PathVariable String id, @RequestBody Site updatedSite) {
        Site site = siteRepository.findById(Integer.valueOf(id)).orElse(null);
        if (site != null) {
            site.setName(updatedSite.getName());
            site.setAddress(updatedSite.getAddress());
            site.setDescription(updatedSite.getDescription());
            site.setOrganisation(updatedSite.getOrganisation());
            return siteRepository.save(site);
        }
        return null;
    }

    @DeleteMapping("/site/{id}")
    public String deleteSite(@PathVariable String id) {
        if (siteRepository.existsById(Integer.valueOf(id))) {
            siteRepository.deleteById(Integer.valueOf(id));
            return "Site with id " + id + " has been deleted successfully.";
        }
        return "Site not found.";
    }
}

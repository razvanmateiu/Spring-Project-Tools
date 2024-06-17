package com.example.ToolManagment.api.sites;

import com.example.ToolManagment.api.sites.dto.SitesDtoAdd;
import com.example.ToolManagment.api.sites.dto.SitesDtoUpdate;
import com.example.ToolManagment.domain.sites.Sites;
import com.example.ToolManagment.domain.sites.SitesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sites")
public class SitesController {
    final SitesRepository sitesRepository;

    public SitesController(SitesRepository sitesRepository) {
        this.sitesRepository = sitesRepository;
    }

    @GetMapping("/all")
    public List<Sites> getAllSites() {
        return sitesRepository.findAll();
    }

    @GetMapping("/{id}")
    Sites getById(@PathVariable Integer id) {
        return sitesRepository.findById(id).get();
    }

    @PostMapping("/add")
    Sites add(@RequestBody SitesDtoAdd commandDto) {
        Sites siteToBeSaved = new Sites();
        siteToBeSaved.setStreetName(commandDto.getStreetName());
        siteToBeSaved.setStreetNumber(commandDto.getStreetNumber());
        siteToBeSaved.setCity(commandDto.getCity());
        siteToBeSaved.setPostalCode(commandDto.getPostalCode());
        siteToBeSaved.setIdPerson(commandDto.getIdPerson());
        return sitesRepository.save(siteToBeSaved);

    }

    @PostMapping("/update/{id}")
    Sites update(@PathVariable Integer id,
                 @RequestBody SitesDtoUpdate updateDto) {
        Sites siteToUpdate = sitesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("The site with id: " + id + " does not exist"));
        siteToUpdate.setIdPerson(updateDto.getIdPerson());

        return sitesRepository.save(siteToUpdate);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> delete(@PathVariable Integer id) {
        Sites siteToDelete = sitesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Site with the id " + id + " does not exist"));
        sitesRepository.delete(siteToDelete);
        return ResponseEntity.ok("Site has been deleted");
    }

}

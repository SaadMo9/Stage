package net.guides.springboot2.springboot2jpacrudexample.controller;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Client;
import net.guides.springboot2.springboot2jpacrudexample.model.Materiel;
import net.guides.springboot2.springboot2jpacrudexample.repository.MaterielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2")
public class MaterielController {
    @Autowired
    private MaterielRepository materielRepository;

    @GetMapping("/materiels")
    public List<Materiel> getAllMateriels() {
        return materielRepository.findAll();
    }

    @GetMapping("/clients/materiels/{id}")
    public ResponseEntity<Materiel> getMaterilById(@PathVariable(value = "id") Long clientId)
            throws ResourceNotFoundException {
        Materiel materiel = materielRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client introuvable pour cet id :: " + clientId));
        return ResponseEntity.ok().body(materiel);
    }

    @PostMapping("/materiels")
    public Materiel createMateriel(@Valid @RequestBody Materiel materiel) {
        return materielRepository.save(materiel);
    }
}

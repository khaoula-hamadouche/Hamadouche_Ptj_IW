package com.example.demo.controller;

import com.example.demo.model.RendezVous;
import com.example.demo.service.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/rendezvous")
public class RendezVousController {

    @Autowired
    private RendezVousService rendezVousService;

    @PostMapping
    public ResponseEntity<RendezVous> ajouterRendezVous(@Valid @RequestBody RendezVous rendezVous) {
        return ResponseEntity.ok(rendezVousService.ajouterRendezVous(rendezVous));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RendezVous> modifierRendezVous(@PathVariable Long id, @Valid @RequestBody RendezVous rendezVous) {
        return ResponseEntity.ok(rendezVousService.modifierRendezVous(id, rendezVous));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerRendezVous(@PathVariable Long id) {
        rendezVousService.supprimerRendezVous(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<RendezVous>> getRendezVousParClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(rendezVousService.getRendezVousParClient(clientId));
    }

}

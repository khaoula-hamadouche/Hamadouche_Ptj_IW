package com.example.demo.controller;

import com.example.demo.model.Disponibilite;
import com.example.demo.service.DisponibiliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/disponibilites")
public class DisponibiliteController {

    @Autowired
    private DisponibiliteService disponibiliteService;

    @PostMapping
    public ResponseEntity<Disponibilite> ajouterDisponibilite(@Valid @RequestBody Disponibilite disponibilite) {
        return ResponseEntity.ok(disponibiliteService.ajouterDisponibilite(disponibilite));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disponibilite> modifierDisponibilite(@PathVariable Long id, @Valid @RequestBody Disponibilite disponibilite) {
        return ResponseEntity.ok(disponibiliteService.modifierDisponibilite(id, disponibilite));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerDisponibilite(@PathVariable Long id) {
        disponibiliteService.supprimerDisponibilite(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/professionnel/{professionnelId}")
    public ResponseEntity<List<Disponibilite>> getDisponibilitesParProfessionnel(@PathVariable Long professionnelId) {
        return ResponseEntity.ok(disponibiliteService.getDisponibilitesParProfessionnel(professionnelId));
    }
}

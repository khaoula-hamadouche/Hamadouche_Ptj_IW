package com.example.demo.controller;

import com.example.demo.model.Utilisateur;
import com.example.demo.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping
    public ResponseEntity<Utilisateur> ajouterUtilisateur(@Valid @RequestBody Utilisateur utilisateur) {
        Utilisateur nouvelUtilisateur = utilisateurService.ajouterUtilisateur(utilisateur);
        return ResponseEntity.ok(nouvelUtilisateur);
    }

    @GetMapping
    public ResponseEntity<List<Utilisateur>> listerUtilisateurs() {
        return ResponseEntity.ok(utilisateurService.listerUtilisateurs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurParId(@PathVariable Long id) {
        return utilisateurService.getUtilisateurParId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> modifierUtilisateur(@PathVariable Long id, @Valid @RequestBody Utilisateur utilisateur) {
        return ResponseEntity.ok(utilisateurService.modifierUtilisateur(id, utilisateur));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerUtilisateur(@PathVariable Long id) {
        utilisateurService.supprimerUtilisateur(id);
        return ResponseEntity.noContent().build();
    }
}

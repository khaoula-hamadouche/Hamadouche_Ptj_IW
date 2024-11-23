package com.example.demo.service;

import com.example.demo.model.Utilisateur;
import com.example.demo.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur modifierUtilisateur(Long id, Utilisateur utilisateur) {
        Optional<Utilisateur> utilisateurExistant = utilisateurRepository.findById(id);
        if (utilisateurExistant.isPresent()) {
            utilisateur.setId(id);
            return utilisateurRepository.save(utilisateur);
        }
        throw new RuntimeException("Utilisateur non trouvé");
    }

    public void supprimerUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

    public List<Utilisateur> listerUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUtilisateurParId(Long id) {
        return utilisateurRepository.findById(id);
    }




}

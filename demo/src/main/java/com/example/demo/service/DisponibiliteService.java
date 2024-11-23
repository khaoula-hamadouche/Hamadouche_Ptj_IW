package com.example.demo.service;

import com.example.demo.model.Disponibilite;
import com.example.demo.repository.DisponibiliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisponibiliteService {

    @Autowired
    private DisponibiliteRepository disponibiliteRepository;

    public Disponibilite ajouterDisponibilite(Disponibilite disponibilite) {
        return disponibiliteRepository.save(disponibilite);
    }

    public Disponibilite modifierDisponibilite(Long id, Disponibilite disponibilite) {
        disponibilite.setId(id);
        return disponibiliteRepository.save(disponibilite);
    }

    public void supprimerDisponibilite(Long id) {
        disponibiliteRepository.deleteById(id);
    }

    public List<Disponibilite> getDisponibilitesParProfessionnel(Long professionnelId) {
        return disponibiliteRepository.findByProfessionnelId(professionnelId);
    }
}

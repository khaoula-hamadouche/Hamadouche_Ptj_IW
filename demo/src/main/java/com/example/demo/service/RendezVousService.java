package com.example.demo.service;

import com.example.demo.model.RendezVous;
import com.example.demo.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendezVousService {

    @Autowired
    private RendezVousRepository rendezVousRepository;

    public RendezVous ajouterRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    public RendezVous modifierRendezVous(Long id, RendezVous rendezVous) {
        rendezVous.setId(id);
        return rendezVousRepository.save(rendezVous);
    }

    public void supprimerRendezVous(Long id) {
        rendezVousRepository.deleteById(id);
    }

    public List<RendezVous> getRendezVousParClient(Long clientId) {
        return rendezVousRepository.findByClientId(clientId);
    }

}

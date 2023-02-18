package tn.addinn.data.kaddem.services;

import org.springframework.stereotype.Service;
import tn.addinn.data.kaddem.entities.Contrat;
import tn.addinn.data.kaddem.repositories.ContratRepository;

import java.util.List;

@Service
public class IContratServiceImp implements IContratServices {

    private final ContratRepository contratRepository;

    public IContratServiceImp(ContratRepository contratRepository) {

        this.contratRepository = contratRepository;
    }

    @Override
    public void ajouterContrat(Contrat c) {

        contratRepository.save(c);
    }

    @Override
    public void updateContrat(Contrat c) {

        contratRepository.save(c);
    }

    @Override
    public List<Contrat> getAllContrat() {

        return contratRepository.findAll();
    }

    @Override
    public Contrat getByIdContrat(Integer id) {

        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteContrat(Integer id) {

        contratRepository.deleteById(id);
    }
}

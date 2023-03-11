package tn.addinn.data.kaddem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.addinn.data.kaddem.entities.Departement;
import tn.addinn.data.kaddem.entities.Universite;
import tn.addinn.data.kaddem.repositories.DepartementRepository;
import tn.addinn.data.kaddem.repositories.UniversiteRepository;

import java.util.List;

@Service
public class IDepartementServiceImp implements IDepartementServices{

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private UniversiteRepository universiteRepository;
    @Override
    public void ajouterDepartement(Departement d) {
        departementRepository.save(d);
    }

    @Override
    public void updateDepartement(Departement d) {
        departementRepository.save(d);
    }

    @Override
    public List<Departement> getAllDepartement() {
        return departementRepository.findAll();
    }

    @Override
    public Departement getByIdDepartement(Integer id) {
        return departementRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteDepartement(Integer id) {
        departementRepository.deleteById(id);
    }

    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite){
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        return universite.getDepartement();
    }
}

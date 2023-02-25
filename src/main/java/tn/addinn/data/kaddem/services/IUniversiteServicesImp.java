package tn.addinn.data.kaddem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.addinn.data.kaddem.entities.Departement;
import tn.addinn.data.kaddem.entities.Universite;
import tn.addinn.data.kaddem.repositories.DepartementRepository;
import tn.addinn.data.kaddem.repositories.UniversiteRepository;

import java.util.List;

@Service
public class IUniversiteServicesImp implements IUniversiteServices{

    @Autowired
    private UniversiteRepository universiteRepository;
    @Autowired
    private DepartementRepository departementRepository;
    @Override
    public void ajoutUniversite(Universite u) {
        universiteRepository.save(u);
    }

    @Override
    public void updateUniversite(Universite u) {
        universiteRepository.save(u);
    }

    @Override
    public List<Universite> getAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite getByIdUniversite(Integer id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUniversite(Integer id) {
        universiteRepository.deleteById(id);
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement){
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Departement departement = departementRepository.findById(idDepartement).orElse(null);
        if (universite == null || departement == null) {
            throw new IllegalArgumentException("L'université ou le département n'existe pas");
        }

        departement.setUniversite(universite);
        departementRepository.save(departement);


    }
}

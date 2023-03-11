package tn.addinn.data.kaddem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.addinn.data.kaddem.entities.Departement;
import tn.addinn.data.kaddem.entities.Universite;
import tn.addinn.data.kaddem.repositories.DepartementRepository;
import tn.addinn.data.kaddem.repositories.UniversiteRepository;

import javax.transaction.Transactional;
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

    @Transactional
    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement){
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Departement departement = departementRepository.findById(idDepartement).orElse(null);

        Assert.notNull(universite, "universite must not be null.") ;
        Assert.notNull(departement, "departement must not be null.") ;

        universite.getDepartement().add(departement);
        //si on ajoute @transactional on peut eliminer cette ligne
        /*universiteRepository.save(universite);*/

    }



}

package tn.addinn.data.kaddem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.addinn.data.kaddem.entities.Departement;
import tn.addinn.data.kaddem.entities.Etudiant;
import tn.addinn.data.kaddem.repositories.DepartementRepository;
import tn.addinn.data.kaddem.repositories.EtudiantRepository;

import java.util.List;

@Service
public class IEtudiantServiceImp implements IEtudiantServices {
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private DepartementRepository departementRepository;



    @Override
    public void ajouterEtudiant(Etudiant e) {
        etudiantRepository.save(e);
    }

    @Override
    public void updateEtudiant(Etudiant e) {
        etudiantRepository.save(e);
    }

    @Override
    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getByIdEtudiant(Integer id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEtudiant(Integer id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId){
        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElse(null);
        Departement departement = departementRepository.findById(departementId).orElse(null);

        //verification des objects
        if ((etudiant!=null)&&(departement!=null)){
            //traitment
            etudiant.setDepartement(departement);
            //departement.getEtudiants().add(etudiant);
            //on va faire le save
            etudiantRepository.save(etudiant);
        }
    }
}

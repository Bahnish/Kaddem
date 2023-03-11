package tn.addinn.data.kaddem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.addinn.data.kaddem.entities.Contrat;
import tn.addinn.data.kaddem.entities.Departement;
import tn.addinn.data.kaddem.entities.Equipe;
import tn.addinn.data.kaddem.entities.Etudiant;
import tn.addinn.data.kaddem.repositories.ContratRepository;
import tn.addinn.data.kaddem.repositories.DepartementRepository;
import tn.addinn.data.kaddem.repositories.EquipeRepository;
import tn.addinn.data.kaddem.repositories.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IEtudiantServiceImp implements IEtudiantServices {
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private ContratRepository contratRepository;

    @Autowired
    private EquipeRepository equipeRepository;



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
    @Override
    @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe){
        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        Assert.notNull(contrat, "univ must not be null");
        Assert.notNull(equipe, "equi must not be null");
        Assert.notNull(e, "etudiant must not be null");

        List<Equipe> equipes = new ArrayList<>();
        equipes.add(equipe);
        e.setEquipes(equipes);
        etudiantRepository.saveAndFlush(e);
        contrat.setEtudiant(e);
        //contratRepository.save(contrat);
        return e;
    }

    public List<Etudiant> getEtudiantsByDepartement (Integer idDepartement){
     /* Departement departement = departementRepository.findById(idDepartement).orElse(null);
      Assert.notNull(departement, "departement must not be null");
      return departement.getEtudiants();*/
        return  etudiantRepository.findEtudiantByDepartement_IdDepart(idDepartement);

    }

}

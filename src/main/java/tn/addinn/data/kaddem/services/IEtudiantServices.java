package tn.addinn.data.kaddem.services;

import tn.addinn.data.kaddem.entities.Etudiant;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

public interface IEtudiantServices {
    void ajouterEtudiant(Etudiant e);
    void updateEtudiant(Etudiant e);
    List<Etudiant> getAllEtudiant();
    Etudiant getByIdEtudiant(Integer id);
    void deleteEtudiant(Integer id);



     void assignEtudiantToDepartement(Integer etudiantId, Integer
            departementId) ;

     Etudiant  addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat,Integer idEquipe);

     public List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);


}

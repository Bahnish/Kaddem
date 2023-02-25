package tn.addinn.data.kaddem.services;

import tn.addinn.data.kaddem.entities.Etudiant;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IEtudiantServices {
    void ajouterEtudiant(Etudiant e);
    void updateEtudiant(Etudiant e);
    List<Etudiant> getAllEtudiant();
    Etudiant getByIdEtudiant(Integer id);
    void deleteEtudiant(Integer id);

    abstract void assignEtudiantToDepartement(Integer etudiantId, Integer
            departementId) ;

     Etudiant  addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat,Integer idEquipe);
}

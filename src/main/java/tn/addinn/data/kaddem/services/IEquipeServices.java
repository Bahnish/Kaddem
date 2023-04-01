package tn.addinn.data.kaddem.services;

import tn.addinn.data.kaddem.entities.Equipe;
import tn.addinn.data.kaddem.entities.Etudiant;

import java.util.List;

public interface IEquipeServices {
    void ajouterEquipe(Equipe e);
    void updateEquipe(Equipe e);
    List<Equipe> getAllEquipe();
    Equipe getByIdEquipe(Integer id);
    void deleteEquipe(Integer id);
    void faireEvoluerEquipes();
}

package tn.addinn.data.kaddem.services;

import tn.addinn.data.kaddem.entities.Departement;
import tn.addinn.data.kaddem.entities.DetailEquipe;

import java.util.List;

public interface IDetailEquipeServices {
    void ajouterDetailEquipe(DetailEquipe de);
    void updateDetailEquipe(DetailEquipe de);
    List<DetailEquipe> getAllDetailEquipe();
    DetailEquipe getByIdDetailEquipe(Integer id);
    void deleteDetailEquipe(Integer id);
}

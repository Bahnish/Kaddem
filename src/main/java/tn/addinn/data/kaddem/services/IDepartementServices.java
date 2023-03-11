package tn.addinn.data.kaddem.services;

import tn.addinn.data.kaddem.entities.Departement;
import tn.addinn.data.kaddem.entities.Equipe;

import java.util.List;

public interface IDepartementServices {
    void ajouterDepartement(Departement d);
    void updateDepartement(Departement d);
    List<Departement> getAllDepartement();
    Departement getByIdDepartement(Integer id);
    void deleteDepartement(Integer id);

    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);


}

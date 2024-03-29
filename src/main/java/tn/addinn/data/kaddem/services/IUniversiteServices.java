package tn.addinn.data.kaddem.services;

import tn.addinn.data.kaddem.entities.Departement;
import tn.addinn.data.kaddem.entities.Universite;

import java.util.List;

public interface IUniversiteServices {

    void ajoutUniversite(Universite u);
    void updateUniversite(Universite u);
    List<Universite> getAllUniversite();
    Universite getByIdUniversite(Integer id);
    void deleteUniversite(Integer id);

    void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);

    List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);


}

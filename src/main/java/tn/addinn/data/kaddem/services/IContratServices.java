package tn.addinn.data.kaddem.services;

import tn.addinn.data.kaddem.entities.Contrat;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface IContratServices {
    void ajouterContrat(Contrat c);
    Contrat updateContrat(Contrat d);
    List<Contrat> getAllContrat();
    Contrat getByIdContrat(Integer id);
    void deleteContrat(Integer id);

    Contrat affectContratToEtudiant (Contrat ce, String nomE,String prenomE);

    public map<String,float> getMontantContartEntreDeuxDate(int idUniv, Date startDate, Date endDate);
}
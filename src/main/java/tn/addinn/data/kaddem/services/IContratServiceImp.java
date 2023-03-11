package tn.addinn.data.kaddem.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.addinn.data.kaddem.entities.Contrat;
import tn.addinn.data.kaddem.entities.Etudiant;
import tn.addinn.data.kaddem.entities.Universite;
import tn.addinn.data.kaddem.repositories.ContratRepository;
import tn.addinn.data.kaddem.repositories.EquipeRepository;
import tn.addinn.data.kaddem.repositories.EtudiantRepository;
import tn.addinn.data.kaddem.repositories.UniversiteRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IContratServiceImp implements IContratServices {

    private final ContratRepository contratRepository;

    private  final EtudiantRepository etudiantRepository;

    private  final UniversiteRepository universiteRepository;



    @Override
    public void ajouterContrat(Contrat c) {

        contratRepository.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat c) {

       return contratRepository.save(c);
    }

    @Override
    public List<Contrat> getAllContrat() {

        return contratRepository.findAll();
    }

    @Override
    public Contrat getByIdContrat(Integer id) {

        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteContrat(Integer id) {

        contratRepository.deleteById(id);
    }

    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE){
        Etudiant e = etudiantRepository.getByNomEAndPrenomE(nomE , prenomE).orElse(null);
        Assert.notNull(e, "etudiant must not be null");
        if (e.getContrats().size() > 5){
            System.out.println("vous avez depassé le nombre max de contrat");
            return null ;
        };
        ce.setEtudiant(e);
        return updateContrat(ce);
    }

    public map<String,float> getMontantContartEntreDeuxDate(int idUniv, Date startDate, Date endDate){
        Universite universite = universiteRepository.findUniversiteByIdUniv(idUniv).orElse(null);

    }

}

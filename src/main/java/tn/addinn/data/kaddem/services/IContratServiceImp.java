package tn.addinn.data.kaddem.services;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.addinn.data.kaddem.entities.Contrat;
import tn.addinn.data.kaddem.entities.Etudiant;
import tn.addinn.data.kaddem.repositories.ContratRepository;
import tn.addinn.data.kaddem.repositories.EtudiantRepository;
import tn.addinn.data.kaddem.repositories.UniversiteRepository;

import java.util.*;
import java.time.LocalDate;

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
    @Scheduled(fixedRate = 6000*5)
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

    //public map<String,float> getMontantContartEntreDeuxDate(int idUniv, Date startDate, Date endDate){
        //Universite universite = universiteRepository.findUniversiteByIdUniv(idUniv).orElse(null);

    //}//

    @Override
    public Map<String, Float> getMontantContartEntreDeuxDate(int idUniv, Date startDate, Date endDate) {
        List<Contrat> listC = contratRepository.findAll();
        Map<String, Float> mapc = new HashMap<>();

        for (Contrat c : listC) {
            if (c.getDateFinContrat().before(startDate) || c.getDateDebutContrat().after(endDate)) {
                listC.remove(c);
            } else {
                String specialite = c.getSpecialite().toString();
                float montant = mapc.getOrDefault(specialite, 0f);
                mapc.put(specialite, montant);
            }
        }

        return mapc;
    }



    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        List <Contrat> listC = new ArrayList<>();
        listC.addAll(contratRepository.findAllByArchiveIsFalse());
        for(Contrat c:listC) {
            if (c.getDateFinContrat().before(startDate) || c.getDateDebutContrat().after(endDate))
                listC.remove(c);}

        return listC.size();
    }

    @Override
    @Scheduled(cron = "0 0 13 * * ?")
    public String retrieveAndUpdateStatusContrat() {
        /*LocalDate date = LocalDate.now();
        LocalDate datefin =date.plusDays(15);*/
        Date date = new Date();
        Date datefin = DateUtils.addDays(date, 15);

        List <Contrat> listC = new ArrayList<>();
        List <Contrat> listR = new ArrayList<>();

        listC.addAll(contratRepository.findAllByArchiveIsFalse());
        for(Contrat c:listC) {
            if (c.getDateFinContrat().before(date) ){
                c.setArchive(true);
                contratRepository.save(c);
            }
            else if (c.getDateFinContrat().after(date) && c.getDateFinContrat().before(datefin))
            {listR.add(c); }


        }

        return listR.toString();


    }


}

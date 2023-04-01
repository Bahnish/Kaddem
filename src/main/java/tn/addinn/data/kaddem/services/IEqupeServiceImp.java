package tn.addinn.data.kaddem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.addinn.data.kaddem.entities.Equipe;
import tn.addinn.data.kaddem.entities.Niveau;
import tn.addinn.data.kaddem.repositories.EquipeRepository;

import java.util.List;

@Service
public class IEqupeServiceImp implements IEquipeServices{
    @Autowired
    private EquipeRepository equipeRepository;
    @Override
    public void ajouterEquipe(Equipe e) {
        equipeRepository.save(e);
    }

    @Override
    public void updateEquipe(Equipe e) {
        equipeRepository.save(e);
    }

    @Override
    public List<Equipe> getAllEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe getByIdEquipe(Integer id) {
        return equipeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEquipe(Integer id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public void faireEvoluerEquipes() {
        List<Equipe> listE = equipeRepository.findAll();
        for(Equipe e:listE) {
            if (e.getEtudiants().size()==3 ){
                if (e.getNiveau()== Niveau.JUNIOR)
                {e.setNiveau(Niveau.SENIOR);
                    equipeRepository.save(e);}
                else if (e.getNiveau()==Niveau.SENIOR) {
                    e.setNiveau(Niveau.EXPERT);
                    equipeRepository.save(e);

                }
            }



        }

    }
}


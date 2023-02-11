package tn.addinn.data.kaddem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.addinn.data.kaddem.entities.Contrat;
import tn.addinn.data.kaddem.entities.DetailEquipe;
public interface DetailEquipeRepository extends JpaRepository<DetailEquipe, Integer> {
}

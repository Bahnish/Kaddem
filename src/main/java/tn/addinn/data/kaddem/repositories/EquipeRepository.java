package tn.addinn.data.kaddem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.addinn.data.kaddem.entities.Equipe;
import tn.addinn.data.kaddem.entities.Etudiant;
import tn.addinn.data.kaddem.entities.OptionE;
import tn.addinn.data.kaddem.entities.Specialite;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> { }

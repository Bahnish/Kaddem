package tn.addinn.data.kaddem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.addinn.data.kaddem.entities.Contrat;
import tn.addinn.data.kaddem.entities.Departement;

import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {

    @Query("select c from Contrat c where c.archive = false")
    List<Contrat> findAllByArchiveIsFalse();
    List<Contrat> findAllByArchiveIsTrue();
}

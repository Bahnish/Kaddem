package tn.addinn.data.kaddem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.addinn.data.kaddem.entities.Departement;

import java.util.List;
import java.util.Optional;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {

    @Query(value = "select * from departement d\n" +
            "order by (SELECT count(*) from etudiant e " +
            "WHERE d.id_depart = e.departement_id_depart);", nativeQuery = true)
    List<Departement> getListDepartementsTrieesparEtudiantsSQL();

}

package tn.addinn.data.kaddem.entities;
import javax.persistence.*;
import java.util.List;


@Entity
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int idDepart;
    private String nomDepart;
    @OneToMany(mappedBy ="departement")
    private List<Etudiant> etudiants;
    @ManyToOne
    private Universite universite ;


}

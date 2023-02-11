package tn.addinn.data.kaddem.entities;

import javax.persistence.*;
import java.util.List;

@Table( name = "etudiants")
@Entity
public class Etudiant {


    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private int idEtudiant;
    private String prenomE;
    private String nomE;

    @Enumerated(EnumType.STRING)
    private OptionE optionE;
    @ManyToOne
    private Departement departement;
    @OneToMany(mappedBy = "etudiant")
    private List<Contrat> contrats;

    @ManyToMany(mappedBy = "etudiants")
    private List<Equipe> equipes;


}

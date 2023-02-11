package tn.addinn.data.kaddem.entities;
import javax.persistence.*;
import java.util.List;

@Table( name = "universite")
@Entity
public class Universite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int idUniv;
    private String nomUniv;


    @OneToMany
    List<Departement> departement;

}

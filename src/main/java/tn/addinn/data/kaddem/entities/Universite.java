package tn.addinn.data.kaddem.entities;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table( name = "universite")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Universite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int idUniv;
    private String nomUniv;


    @OneToMany
    List<Departement> departement;

}

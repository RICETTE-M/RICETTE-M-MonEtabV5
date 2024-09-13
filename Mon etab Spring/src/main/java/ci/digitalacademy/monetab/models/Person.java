package ci.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
//Generation de table partagée table
@Inheritance(strategy = InheritanceType.JOINED)
//Generation d'une seule table
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type")
@Table(name = "Person")
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstname")
    private String nom;

    @Column(name = "lastname")
    private String prenom;

    @Column(name = "tel")
    private String telephone;

    @Column(name = "city")
    private String ville;

    @Column(name = "email")
    private String email;

    @Column(name = "genre")
    private String genre;

    @OneToOne
    private Address address;

    @OneToOne
    private User user;
}

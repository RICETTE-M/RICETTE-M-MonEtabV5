package ci.digitalacademy.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationStudentDTO {

    private String nom;
    private String prenom;
    private String matricule;
    private String country;
    private String city;
    private String street;
    private String pseudo;
    private String email;
}

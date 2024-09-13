package ci.digitalacademy.monetab.services.dto;

import ci.digitalacademy.monetab.models.Address;
import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.models.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonnDTO {


    private Long id;

    private String nom;

    private String prenom;

    private String telephone;

    private String ville;

    private String email;

    private String genre;

    private AddressDTO addressDTO;

    private UserDTO userDTO;
}

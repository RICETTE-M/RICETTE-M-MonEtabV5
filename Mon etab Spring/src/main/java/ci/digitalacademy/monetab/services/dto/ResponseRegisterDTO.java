package ci.digitalacademy.monetab.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseRegisterDTO {

    @JsonIgnoreProperties({"id","classe","datenaiss","age","telephone","genre", "user", "address"})
    private StudentDTO student;

    @JsonIgnoreProperties({"id"})
    private AddressDTO address;

}

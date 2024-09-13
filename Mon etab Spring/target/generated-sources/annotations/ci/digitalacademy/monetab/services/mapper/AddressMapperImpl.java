package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.Address;
import ci.digitalacademy.monetab.models.School;
import ci.digitalacademy.monetab.services.dto.AddressDTO;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T13:46:25+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressDTO toDto(Address entity) {
        if ( entity == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setId( entity.getId() );
        addressDTO.setCountry( entity.getCountry() );
        addressDTO.setCity( entity.getCity() );
        addressDTO.setStreet( entity.getStreet() );

        return addressDTO;
    }

    @Override
    public Address toEntity(AddressDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( dto.getId() );
        address.setCountry( dto.getCountry() );
        address.setCity( dto.getCity() );
        address.setStreet( dto.getStreet() );

        return address;
    }

    @Override
    public SchoolDTO fromEntity(School school) {
        if ( school == null ) {
            return null;
        }

        SchoolDTO schoolDTO = new SchoolDTO();

        schoolDTO.setId( school.getId() );
        schoolDTO.setName( school.getName() );
        schoolDTO.setUrl_logo( school.getUrl_logo() );

        return schoolDTO;
    }
}

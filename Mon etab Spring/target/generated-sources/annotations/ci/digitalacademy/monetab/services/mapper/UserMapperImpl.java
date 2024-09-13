package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.School;
import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;
import ci.digitalacademy.monetab.services.dto.UserDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T13:46:24+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( entity.getId() );
        userDTO.setSpeudo( entity.getSpeudo() );
        userDTO.setPassword( entity.getPassword() );
        userDTO.setCreationdate( entity.getCreationdate() );

        return userDTO;
    }

    @Override
    public User toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setSpeudo( dto.getSpeudo() );
        user.setPassword( dto.getPassword() );
        user.setCreationdate( dto.getCreationdate() );

        return user;
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

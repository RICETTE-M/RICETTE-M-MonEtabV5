package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.RoleUser;
import ci.digitalacademy.monetab.models.School;
import ci.digitalacademy.monetab.services.dto.RoleUserDTO;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T13:46:24+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class RoleUserMapperImpl implements RoleUserMapper {

    @Override
    public RoleUserDTO toDto(RoleUser entity) {
        if ( entity == null ) {
            return null;
        }

        RoleUserDTO roleUserDTO = new RoleUserDTO();

        roleUserDTO.setId( entity.getId() );
        roleUserDTO.setRole( entity.getRole() );
        roleUserDTO.setUser( entity.getUser() );

        return roleUserDTO;
    }

    @Override
    public RoleUser toEntity(RoleUserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RoleUser roleUser = new RoleUser();

        roleUser.setId( dto.getId() );
        roleUser.setRole( dto.getRole() );
        roleUser.setUser( dto.getUser() );

        return roleUser;
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

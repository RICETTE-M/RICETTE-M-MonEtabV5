package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.School;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T13:46:25+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class SchoolMapperImpl implements SchoolMapper {

    @Override
    public SchoolDTO toDto(School entity) {
        if ( entity == null ) {
            return null;
        }

        SchoolDTO schoolDTO = new SchoolDTO();

        schoolDTO.setId( entity.getId() );
        schoolDTO.setName( entity.getName() );
        schoolDTO.setUrl_logo( entity.getUrl_logo() );

        return schoolDTO;
    }

    @Override
    public School toEntity(SchoolDTO dto) {
        if ( dto == null ) {
            return null;
        }

        School school = new School();

        school.setId( dto.getId() );
        school.setName( dto.getName() );
        school.setUrl_logo( dto.getUrl_logo() );

        return school;
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

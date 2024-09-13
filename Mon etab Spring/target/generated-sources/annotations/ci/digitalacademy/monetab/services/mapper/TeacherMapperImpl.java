package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.School;
import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T13:46:24+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class TeacherMapperImpl implements TeacherMapper {

    @Override
    public TeacherDTO toDto(Teacher entity) {
        if ( entity == null ) {
            return null;
        }

        TeacherDTO teacherDTO = new TeacherDTO();

        teacherDTO.setId( entity.getId() );
        teacherDTO.setNom( entity.getNom() );
        teacherDTO.setPrenom( entity.getPrenom() );
        teacherDTO.setTelephone( entity.getTelephone() );
        teacherDTO.setVille( entity.getVille() );
        teacherDTO.setEmail( entity.getEmail() );
        teacherDTO.setGenre( entity.getGenre() );
        teacherDTO.setMatiere( entity.getMatiere() );
        teacherDTO.setVacant( entity.getVacant() );

        return teacherDTO;
    }

    @Override
    public Teacher toEntity(TeacherDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setId( dto.getId() );
        teacher.setNom( dto.getNom() );
        teacher.setPrenom( dto.getPrenom() );
        teacher.setTelephone( dto.getTelephone() );
        teacher.setVille( dto.getVille() );
        teacher.setEmail( dto.getEmail() );
        teacher.setGenre( dto.getGenre() );
        teacher.setMatiere( dto.getMatiere() );
        teacher.setVacant( dto.getVacant() );

        return teacher;
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

package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.School;
import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;
import ci.digitalacademy.monetab.services.dto.StudentDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T13:46:25+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentDTO toDto(Student entity) {
        if ( entity == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId( entity.getId() );
        studentDTO.setNom( entity.getNom() );
        studentDTO.setPrenom( entity.getPrenom() );
        studentDTO.setTelephone( entity.getTelephone() );
        studentDTO.setVille( entity.getVille() );
        studentDTO.setEmail( entity.getEmail() );
        studentDTO.setGenre( entity.getGenre() );
        studentDTO.setDatenaiss( entity.getDatenaiss() );
        studentDTO.setMatricule( entity.getMatricule() );
        studentDTO.setClasse( entity.getClasse() );
        studentDTO.setAge( entity.getAge() );

        return studentDTO;
    }

    @Override
    public Student toEntity(StudentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( dto.getId() );
        student.setNom( dto.getNom() );
        student.setPrenom( dto.getPrenom() );
        student.setTelephone( dto.getTelephone() );
        student.setVille( dto.getVille() );
        student.setEmail( dto.getEmail() );
        student.setGenre( dto.getGenre() );
        student.setDatenaiss( dto.getDatenaiss() );
        student.setMatricule( dto.getMatricule() );
        student.setClasse( dto.getClasse() );
        student.setAge( dto.getAge() );

        return student;
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

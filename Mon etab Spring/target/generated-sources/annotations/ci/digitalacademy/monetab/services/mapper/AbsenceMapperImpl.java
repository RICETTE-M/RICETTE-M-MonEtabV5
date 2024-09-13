package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.Absence;
import ci.digitalacademy.monetab.models.School;
import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.services.dto.AbsenceDTO;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;
import ci.digitalacademy.monetab.services.dto.StudentDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T13:46:24+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class AbsenceMapperImpl implements AbsenceMapper {

    @Override
    public AbsenceDTO toDto(Absence entity) {
        if ( entity == null ) {
            return null;
        }

        AbsenceDTO absenceDTO = new AbsenceDTO();

        absenceDTO.setId( entity.getId() );
        absenceDTO.setAbsence_date( entity.getAbsence_date() );
        absenceDTO.setAbsence_number( entity.getAbsence_number() );
        absenceDTO.setSlug( entity.getSlug() );
        absenceDTO.setStudent( studentToStudentDTO( entity.getStudent() ) );

        return absenceDTO;
    }

    @Override
    public Absence toEntity(AbsenceDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Absence absence = new Absence();

        absence.setId( dto.getId() );
        absence.setAbsence_date( dto.getAbsence_date() );
        if ( dto.getAbsence_number() != null ) {
            absence.setAbsence_number( dto.getAbsence_number() );
        }
        absence.setStudent( studentDTOToStudent( dto.getStudent() ) );
        absence.setSlug( dto.getSlug() );

        return absence;
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

    protected StudentDTO studentToStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId( student.getId() );
        studentDTO.setNom( student.getNom() );
        studentDTO.setPrenom( student.getPrenom() );
        studentDTO.setTelephone( student.getTelephone() );
        studentDTO.setVille( student.getVille() );
        studentDTO.setEmail( student.getEmail() );
        studentDTO.setGenre( student.getGenre() );
        studentDTO.setDatenaiss( student.getDatenaiss() );
        studentDTO.setMatricule( student.getMatricule() );
        studentDTO.setClasse( student.getClasse() );
        studentDTO.setAge( student.getAge() );

        return studentDTO;
    }

    protected Student studentDTOToStudent(StudentDTO studentDTO) {
        if ( studentDTO == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( studentDTO.getId() );
        student.setNom( studentDTO.getNom() );
        student.setPrenom( studentDTO.getPrenom() );
        student.setTelephone( studentDTO.getTelephone() );
        student.setVille( studentDTO.getVille() );
        student.setEmail( studentDTO.getEmail() );
        student.setGenre( studentDTO.getGenre() );
        student.setDatenaiss( studentDTO.getDatenaiss() );
        student.setMatricule( studentDTO.getMatricule() );
        student.setClasse( studentDTO.getClasse() );
        student.setAge( studentDTO.getAge() );

        return student;
    }
}

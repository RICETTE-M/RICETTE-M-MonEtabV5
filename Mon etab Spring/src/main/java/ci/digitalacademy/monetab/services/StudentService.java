package ci.digitalacademy.monetab.services;


import ci.digitalacademy.monetab.services.dto.RegistrationStudentDTO;
import ci.digitalacademy.monetab.services.dto.ResponseRegisterDTO;
import ci.digitalacademy.monetab.services.dto.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentDTO save(StudentDTO studentDTO);

    StudentDTO update(StudentDTO studentDTO);

    Optional<StudentDTO> findOne(Long id);

    List<StudentDTO> findAll();
    StudentDTO update(StudentDTO studentDTO, Long id);

    void delete(Long id);

    List<StudentDTO> findByNomOrGenreOrMatricule(String query , String genre);

    ResponseRegisterDTO registerStudent(RegistrationStudentDTO registrationStudentDTO);
}

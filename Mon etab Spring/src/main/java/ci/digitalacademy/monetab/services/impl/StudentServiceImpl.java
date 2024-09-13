package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.models.enumeration.Gender;
import ci.digitalacademy.monetab.repositories.StudentRepository;
import ci.digitalacademy.monetab.security.AuthorityConstants;
import ci.digitalacademy.monetab.services.AdresseService;
import ci.digitalacademy.monetab.services.RoleUserService;
import ci.digitalacademy.monetab.services.StudentService;
import ci.digitalacademy.monetab.services.UserService;
import ci.digitalacademy.monetab.services.dto.*;
import ci.digitalacademy.monetab.services.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;


@RequiredArgsConstructor
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private  final StudentMapper studentMapper;
    private final AdresseService adresseService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final RoleUserService roleUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        log.debug("Request to save : {}",studentDTO);
        Student student = studentMapper.toEntity(studentDTO);
        student= studentRepository.save(student);

        return  studentMapper.toDto(student);
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        student = studentRepository.save(student);
        return studentMapper.toDto(student);
    }

    @Override
    public Optional<StudentDTO> findOne(Long id) {
        return studentRepository.findById(id).map(student -> {
            return studentMapper.toDto(student);
        });
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(student -> {
            return studentMapper.toDto(student);
        }).toList();
    }

    @Override
    public void delete(Long id) {

        studentRepository.deleteById(id);
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO, Long id) {
        return findOne(id).map(studentDTO1 -> {
            studentDTO1.setNom(studentDTO.getNom());
            studentDTO1.setPrenom(studentDTO.getPrenom());
            studentDTO1.setGenre(studentDTO1.getGenre());
            studentDTO1.setMatricule(studentDTO.getMatricule());
            studentDTO1.setTelephone(studentDTO.getTelephone());
            return save(studentDTO1);
        }).orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }

    @Override
    public List<StudentDTO> findByNomOrGenreOrMatricule(String query, String genre) {
        List<Student> students = studentRepository.findByNomIgnoreCaseOrMatriculeIgnoreCaseAndGenre(query  , query ,genre);
        return students.stream().map(student -> studentMapper.toDto(student)).toList();
    }

    @Override
    public ResponseRegisterDTO registerStudent(RegistrationStudentDTO registrationStudentDTO) {
        log.debug("Request to register student {}", registrationStudentDTO);
        AddressDTO address = modelMapper.map(registrationStudentDTO,AddressDTO.class);
       address= adresseService.save(address); //Enregistrement de l'adresse

        Set<RoleUserDTO> roleUsers = (Set<RoleUserDTO>) roleUserService.findByRole(AuthorityConstants.ROLE_USER);
                UserDTO user = modelMapper.map(registrationStudentDTO,UserDTO.class);
        String password = UUID.randomUUID().toString();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user = userService.save(user);

        StudentDTO student= modelMapper.map(registrationStudentDTO,StudentDTO.class);
        student.setUserDTO(user);
        student.setAddressDTO(address);
        student=save(student);

        ResponseRegisterDTO response = new ResponseRegisterDTO();
        response.setStudent(student);
        response.setAddress(address);
        return response;
    }
}


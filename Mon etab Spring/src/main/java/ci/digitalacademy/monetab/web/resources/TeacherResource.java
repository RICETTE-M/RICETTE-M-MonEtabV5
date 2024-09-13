package ci.digitalacademy.monetab.web.resources;

import ci.digitalacademy.monetab.services.TeacherService;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/teachers")
public class TeacherResource {

    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherDTO> saveTeacher(@RequestBody TeacherDTO teacherDTO){
        log.debug("REST Request to save Teacher : {}", teacherDTO);
        return new  ResponseEntity<>(teacherService.save(teacherDTO), HttpStatus.CREATED) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherDTO> updateTeacher(TeacherDTO teacherDTO, Long id){
        log.debug("REST Request to update Teacher : {}", teacherDTO);
        return new  ResponseEntity<>(teacherService.update(teacherDTO), HttpStatus.OK) ;
    }
}

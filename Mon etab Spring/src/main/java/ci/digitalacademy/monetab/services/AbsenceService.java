package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.services.dto.AbsenceDTO;
import ci.digitalacademy.monetab.services.dto.AddressDTO;

import java.util.List;
import java.util.Optional;

public interface AbsenceService {

    AbsenceDTO save(AbsenceDTO absenceDTO);

    AbsenceDTO update(AbsenceDTO addressDTO);

    Optional<AbsenceDTO> findOne(Long id);

    List<AbsenceDTO> findAll();

    void delete(Long id);

    AbsenceDTO saveAbsence(AbsenceDTO absenceDTO);
}


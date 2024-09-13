package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.School;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;

public interface EntityMapper <D , E>{

    D toDto(E entity);

     E toEntity(D dto);

    SchoolDTO fromEntity(School school);
}

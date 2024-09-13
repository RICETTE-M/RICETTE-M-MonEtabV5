package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.FicheNote;
import ci.digitalacademy.monetab.models.School;
import ci.digitalacademy.monetab.services.dto.FicheNoteDTO;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T13:46:25+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class FicheNoteMapperImpl implements FicheNoteMapper {

    @Override
    public FicheNoteDTO toDto(FicheNote entity) {
        if ( entity == null ) {
            return null;
        }

        FicheNoteDTO ficheNoteDTO = new FicheNoteDTO();

        ficheNoteDTO.setId( entity.getId() );
        ficheNoteDTO.setNote( entity.getNote() );
        ficheNoteDTO.setAnnee( entity.getAnnee() );

        return ficheNoteDTO;
    }

    @Override
    public FicheNote toEntity(FicheNoteDTO dto) {
        if ( dto == null ) {
            return null;
        }

        FicheNote ficheNote = new FicheNote();

        ficheNote.setId( dto.getId() );
        ficheNote.setNote( dto.getNote() );
        ficheNote.setAnnee( dto.getAnnee() );

        return ficheNote;
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

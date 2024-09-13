package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.Note;
import ci.digitalacademy.monetab.models.School;
import ci.digitalacademy.monetab.services.dto.NoteDTO;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T13:46:24+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class NoteMapperImpl implements NoteMapper {

    @Override
    public NoteDTO toDto(Note entity) {
        if ( entity == null ) {
            return null;
        }

        NoteDTO noteDTO = new NoteDTO();

        noteDTO.setId( entity.getId() );
        noteDTO.setNote( entity.getNote() );
        noteDTO.setMatiere( entity.getMatiere() );

        return noteDTO;
    }

    @Override
    public Note toEntity(NoteDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Note note = new Note();

        note.setId( dto.getId() );
        note.setNote( dto.getNote() );
        note.setMatiere( dto.getMatiere() );

        return note;
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

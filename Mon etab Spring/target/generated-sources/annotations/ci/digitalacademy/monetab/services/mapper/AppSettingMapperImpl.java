package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.AppSetting;
import ci.digitalacademy.monetab.models.School;
import ci.digitalacademy.monetab.services.dto.AppSettingDTO;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T13:46:25+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class AppSettingMapperImpl implements AppSettingMapper {

    @Override
    public AppSettingDTO toDto(AppSetting entity) {
        if ( entity == null ) {
            return null;
        }

        AppSettingDTO appSettingDTO = new AppSettingDTO();

        appSettingDTO.setId( entity.getId() );
        appSettingDTO.setSmtpServer( entity.getSmtpServer() );
        appSettingDTO.setSmtpPort( entity.getSmtpPort() );
        appSettingDTO.setSmtpUserName( entity.getSmtpUserName() );
        appSettingDTO.setSmtpPassword( entity.getSmtpPassword() );

        return appSettingDTO;
    }

    @Override
    public AppSetting toEntity(AppSettingDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AppSetting appSetting = new AppSetting();

        appSetting.setId( dto.getId() );
        appSetting.setSmtpServer( dto.getSmtpServer() );
        appSetting.setSmtpPort( dto.getSmtpPort() );
        appSetting.setSmtpUserName( dto.getSmtpUserName() );
        appSetting.setSmtpPassword( dto.getSmtpPassword() );

        return appSetting;
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

package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.services.AppSettingService;
import ci.digitalacademy.monetab.services.FiltreStorageService;
import ci.digitalacademy.monetab.services.SchoolService;
import ci.digitalacademy.monetab.services.dto.AppSettingDTO;
import ci.digitalacademy.monetab.services.dto.RegistrationSchoolDTO;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/AddSchool")
public class SchoolControlleur {

    private final SchoolService schoolService;
    private final AppSettingService appSettingService;

    private final FiltreStorageService filtreStorageService;


    @GetMapping
    public String addSchool(Model model) {
        model.addAttribute("schools", new RegistrationSchoolDTO());
        return "School/addschool";
    }

    @PostMapping
    public String saveSchool(RegistrationSchoolDTO schoolDTO, Model model) {
        log.debug("Request to save school: {}", schoolDTO);

        try {
            // Téléversez le fichier vers Cloudinary et récupérez l'URL
            String logoUrl = filtreStorageService.upload(schoolDTO.getFile());

            // Définissez l'URL du logo dans le DTO
            schoolDTO.setUrl_logo(logoUrl);

            // Associez l'AppSetting à l'école
            AppSettingDTO appSettingDTO = appSettingService.findAll().get(0);
            schoolDTO.setAppSettingDTO(appSettingDTO);

            // Sauvegardez l'école dans la base de données
            schoolService.save(schoolDTO);
            schoolService.initSchool(schoolDTO);
        } catch (IOException e) {
            log.error("Error uploading file: ", e);
            model.addAttribute("errorMessage", "File upload failed. Please try again.");
            return "School/addschool";
        }

        return "redirect:/login";
    }

    @GetMapping("/schoolSetting")
    public String index(Model model){
        List<SchoolDTO> schoolDTOS = schoolService.findAll();
        model.addAttribute("schools",schoolDTOS);
        return "School/schoolSetting";
    }

}

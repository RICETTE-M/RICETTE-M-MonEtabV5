package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.models.AppSetting;
import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.services.AppSettingService;
import ci.digitalacademy.monetab.services.SchoolService;
import ci.digitalacademy.monetab.services.dto.AppSettingDTO;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Dashboard")
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    private final SchoolService schoolService;

    private final AppSettingService appSettingService;

    @GetMapping
    public String showDashboard(Model model){

        List<SchoolDTO> schoolDTOS = schoolService.findAll();
        model.addAttribute("schools",schoolDTOS);
        return "/Home/dashboad";
    }

    @GetMapping("/smtpSetting")
    public String show_AppSetting_page(Model model){
        log.debug("Request to show add teacher forms");
        List<SchoolDTO> schoolDTOS = schoolService.findAll();
        model.addAttribute("schools",schoolDTOS);
        model.addAttribute("appsettings", new AppSetting());
        return "AppSetting/appsting";
    }

    @GetMapping("/updateAppSetting/{id}")
    public String showModifierAppSetting(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes){
        List<SchoolDTO> schoolDTOS = schoolService.findAll();
        log.debug("Request to show update teacher forms");
        Optional<AppSettingDTO> appSettingDTO = appSettingService.findOne(id);
        if (appSettingDTO.isPresent()){
            model.addAttribute("schools",schoolDTOS);
            model.addAttribute("appSettings" , appSettingDTO.get());
            redirectAttributes.addFlashAttribute("message", "Paramettre mis à jour avec succès.");
            return "AppSetting/appsting";
        } else {
            redirectAttributes.addFlashAttribute("message", "Echec de la mise à jour.");
            return "AppSetting/appsting";
        }

    }

    @PostMapping
    public String saveAppSetting(AppSettingDTO appSettingDTO, Model model){
        log.debug("Request to save teacher : {}",appSettingDTO );
        appSettingService.initApp(appSettingDTO);

        return "redirect:/Dashboard";
    }
}

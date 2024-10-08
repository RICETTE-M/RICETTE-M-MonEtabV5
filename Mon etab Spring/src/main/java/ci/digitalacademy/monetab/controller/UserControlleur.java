package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.services.RoleUserService;
import ci.digitalacademy.monetab.services.SchoolService;
import ci.digitalacademy.monetab.services.UserService;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;
import ci.digitalacademy.monetab.services.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Users")
@RequiredArgsConstructor
@Slf4j
public class UserControlleur {

    private final UserService userService;
    private final SchoolService schoolService;
    private final RoleUserService roleUserService;

    @GetMapping
    public String showUserPage(Model model){
        List<SchoolDTO> schoolDTOS = schoolService.findAll();
        List<UserDTO> users = userService.findAll();
        model.addAttribute("schools",schoolDTOS);
        model.addAttribute("users",users);

        return "/User/list";
    }

    @GetMapping("/show_add_user_form")
    public String showAjouterEleve(Model model){

        log.debug("Request to show add user forms");
        List<SchoolDTO> schoolDTOS = schoolService.findAll();
        model.addAttribute("schools",schoolDTOS);
        model.addAttribute("users", new User());
        return "/User/form";
    }

    @PostMapping
    public String saveUser(@ModelAttribute UserDTO userDTO, @RequestParam("confirmPassword") String confirmPassword, Model model) {
        log.debug("Request to save users : {}", userDTO);

        // Vérifier la correspondance des mots de passe
        if (!userDTO.getPassword().equals(confirmPassword)) {
            model.addAttribute("passwordMismatch", true);
            return "/User/form";
        }
        // Définir la date de création
        userDTO.setCreationdate(Instant.now());

        userService.save(userDTO);

        return "redirect:/Users";
    }


    @GetMapping("/updateUser/{id}")
    public String showModifierEleve(Model model, @PathVariable Long id){

        log.debug("Request to show update users forms");
        Optional<UserDTO> user = userService.findOne(id);
        if (user.isPresent()){
            List<SchoolDTO> schoolDTOS = schoolService.findAll();
            model.addAttribute("schools",schoolDTOS);
            model.addAttribute("users" , user.get());
            return "User/form";
        } else {
            return "redirect:/Users";
        }

    }

    @PostMapping("/deleteUser/{id}")
    public String showDeleteTeacher(@PathVariable Long id) {
        log.debug("Request to delete user with id: {}", id);
        userService.delete(id);
        return "redirect:/Users";
    }

    @GetMapping("/search")
    public String searchUsers(@RequestParam LocalDate date, @RequestParam String role, Model model) {
        List<UserDTO> users = userService.findByCreationdateLessThanAndRoleUsers(Instant.from(date.atStartOfDay(ZoneOffset.systemDefault())), role);
        model.addAttribute("users", users);
//        model.addAttribute("date", date);

        model.addAttribute("role", role);
//        model.addAttribute("roles", roleUserService.findAll());

        return "User/list";
    }

}

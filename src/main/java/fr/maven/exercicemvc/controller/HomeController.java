package fr.maven.exercicemvc.controller;

import fr.maven.exercicemvc.entities.User;
import fr.maven.exercicemvc.form.LoginForm;
import fr.maven.exercicemvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

       @GetMapping("/")
        public String home() {
            return "home";
        }

    @GetMapping("/profile")
    public String profil(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("userInfos") != null) {
            model.addAttribute("userInfos", session.getAttribute("userInfos"));
            return "profile";
        }

        return "redirect:/login";

    }

    @RequestMapping(value="/profile/delete/{id}")
    public String suppressionProfil(@PathVariable(name = "id") long id){
           //User user = userService.findById(id);
           userService.deleteProfil(id);
        return "redirect:/";
    }

}

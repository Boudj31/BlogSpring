package fr.maven.exercicemvc.controller;

import fr.maven.exercicemvc.entities.User;
import fr.maven.exercicemvc.form.LoginForm;
import fr.maven.exercicemvc.services.PostService;
import fr.maven.exercicemvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

       @GetMapping("/")
        public String home(Model model) {
           model.addAttribute("posts", postService.findAll());
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
    public String deleteProfil(@PathVariable(name = "id") long id){
           //User user = userService.findById(id);
           userService.deleteProfil(id);
        return "redirect:/";
    }
    @GetMapping("/profile/edit/{id}")
    public String updateFormProfil(@PathVariable("id") long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
           return "updateProfile";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, User user,
                             BindingResult result, Model model) throws Exception {
        if (result.hasErrors()) {
            user.setId(id);
            return "updateProfile";
        }
        userService.updateProfile(user);
        return "redirect:/profile";
    }



}

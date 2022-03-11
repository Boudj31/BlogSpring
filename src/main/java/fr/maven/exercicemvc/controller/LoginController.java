package fr.maven.exercicemvc.controller;

import fr.maven.exercicemvc.entities.User;
import fr.maven.exercicemvc.form.LoginForm;
import fr.maven.exercicemvc.form.RegisterFrom;
import fr.maven.exercicemvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/connexion")
    public String connexion(LoginForm loginForm, HttpServletRequest request, Model model) {
        try {
            User connexionLogin = userService.checkLogin(loginForm);
            if(connexionLogin != null) {
                HttpSession session = request.getSession();
                session.setAttribute("userInfos", connexionLogin);
               // model.addAttribute("userInfos", session.getAttribute("userInfos"));
            }else {
                return "ERROR";
            }


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        return "redirect:/profile";
    }

    @PostMapping("/registerSubmit")
    public String registerPost(User user) throws Exception {
             userService.register(user);
        return "home";
    }
    @GetMapping("/logout")
    public String connexion(HttpServletRequest request) {
                request.getSession().invalidate();
        return "redirect:/";
    }


}

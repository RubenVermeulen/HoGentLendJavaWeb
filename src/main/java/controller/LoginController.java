package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ReservatieDao;

@Controller
public class LoginController {

    
    @Autowired
    private ReservatieDao reservatieDao;
    
    
    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, 
            Model model) {

        if (error != null) {
            model.addAttribute("error", "Ongeldige gebruikersnaam of wachtwoord");
        }
        if (logout != null) {
            model.addAttribute("msg", "Je bent succesvol uitgelogd");
        }
        return "login";
    }
}

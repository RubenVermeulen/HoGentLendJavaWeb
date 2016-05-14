package controller;

import domain.Reservatie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ReservatieDao;

@Controller 
public class ReservatieController {
    
    @Autowired
    private ReservatieDao reservatieDao; 
    
    @RequestMapping(value = "/reservaties", method = RequestMethod.GET)
    public String showAllReservaties(Model model) {
        List<Reservatie> reservaties = reservatieDao.getAllReservaties();
        
        model.addAttribute("reservaties", reservaties);
        
        return "reservaties";
    }
    
}

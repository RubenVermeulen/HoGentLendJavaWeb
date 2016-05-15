package controller;

import domain.Materiaal;
import domain.Reservatie;
import domain.ReservatieLijn;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
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

    @RequestMapping(value = "/reservaties/all", method = RequestMethod.GET)
    public String showAllReservaties(Model model) {
        List<Reservatie> reservaties = reservatieDao.getAllReservaties();

        model.addAttribute("reservaties", reservaties);

        return "reservaties";
    }

    @RequestMapping(value = "/reservaties/starting-from", method = RequestMethod.GET)
    public String showAllReservatiesStartingFrom(Model model) {
        List<Reservatie> reservaties = reservatieDao.getAllReservatiesStartingFrom(Date.from(Instant.now()));

        model.addAttribute("reservaties", reservaties);

        return "reservaties";
    }
    
    @RequestMapping(value = "/reservaties/opgehaald", method = RequestMethod.GET)
    public String showAllReservatiesOpgehaald(Model model) {
        List<Reservatie> reservaties = reservatieDao.getAllReservatiesOpgehaald();

        model.addAttribute("reservaties", reservaties);

        return "reservaties";
    }
    
    

    public List<Materiaal> getMaterialenUitReservaties(List<Reservatie> reservaties) {
        List<ReservatieLijn> reservatieLijnen = new ArrayList<>();
        
        for (Reservatie r : reservaties) {
            for (ReservatieLijn rl : r.getReservatielijnen()) {
                reservatieLijnen.add(rl);
            }
        }
        
        List<Materiaal> materialen = new ArrayList<>();
        if (!reservatieLijnen.isEmpty()) {
            for (ReservatieLijn rl : reservatieLijnen) {
                materialen.add(rl.getMateriaal());
            }
        }
        return materialen;
    }

}

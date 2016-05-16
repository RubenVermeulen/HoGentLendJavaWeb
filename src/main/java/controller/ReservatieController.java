package controller;

import bean.FilterData;
import domain.Materiaal;
import domain.Reservatie;
import domain.ReservatieLijn;
import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.ReservatieDao;
import util.Utils;
import static util.Utils.readJsonFromUrl;

@Controller
public class ReservatieController {
    
    @Autowired
    private ReservatieDao reservatieDao;
    
    @RequestMapping(value = "/reservaties/gereserveerde", method = RequestMethod.GET)
    public String showAllReservaties(Model model, String datum, Principal principal) {
        Date date = Utils.stringToDate(datum);
        List<Reservatie> reservaties = null;
        if (date == null) {
            reservaties = reservatieDao.getAllReservatiesStartingFrom(Date.from(Instant.now()));
        } else {
            reservaties = reservatieDao.getAllReservatiesStartingFrom(date);
        }
        model.addAttribute("username", principal.getName());
        model.addAttribute("isEmptyReservaties", reservaties.isEmpty());
        model.addAttribute("reservaties", reservaties);
        
        return "reservaties";
    }
    
    @RequestMapping(value = "/reservaties/uitgeleende", method = RequestMethod.GET)
    public String showAllReservatiesOpgehaald(Model model, String datum) {
        Date date = Utils.stringToDate(datum);
        List<Reservatie> reservaties = null;
        if (date == null) {
            reservaties = reservatieDao.getAllReservatiesOpgehaald();
        } else {
            reservaties = reservatieDao.getAllReservatiesOpgehaaldStartingFrom(date);
        }
        
        model.addAttribute("isEmptyReservaties", reservaties.isEmpty());
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

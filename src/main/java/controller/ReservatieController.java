package controller;

import bean.FilterData;
import domain.Materiaal;
import domain.Reservatie;
import domain.ReservatieLijn;
import java.io.IOException;
import java.security.Principal;
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
import static util.Utils.readJsonFromUrl;

@Controller
public class ReservatieController {

    @Autowired
    private ReservatieDao reservatieDao;

    @RequestMapping(value = "/reservaties/gereserveerde", method = RequestMethod.GET)
    public String showAllReservaties(Model model, Date datum, Principal principal) throws IOException {
        // todo: handle datum als  die niet een lege string is
        List<Reservatie> reservaties = reservatieDao.getAllReservaties();

        
        JSONObject json = readJsonFromUrl("https://studservice.hogent.be/auth/427629xb/58ec1755dd1302b82b7f9ab88a9d03ef8a10cdc8edc0cea90c41e3697f7ed08a");
        System.out.println(json.getString("TYPE"));
        
        model.addAttribute("username", json.getString("TYPE"));
        model.addAttribute("reservaties", reservaties);

        return "reservaties";
    }
    
    @RequestMapping(value = "/reservaties/uitgeleende", method = RequestMethod.GET)
    public String showAllReservatiesOpgehaald(Model model, Date datum) {
        // todo: handle datum als  die niet een lege string is
        List<Reservatie> reservaties = reservatieDao.getAllReservatiesOpgehaald();

        model.addAttribute("reservaties", reservaties);

        return "reservaties";
    }
   

//    @RequestMapping(value = "/reservaties/starting-from", method = RequestMethod.GET)
//    public String showAllReservatiesStartingFrom(Model model, String datum) {
//        
//        List<Reservatie> reservaties = reservatieDao.getAllReservatiesStartingFrom(Date.from(Instant.now()));
//
//        model.addAttribute("reservaties", reservaties);
//
//        return "reservaties";
//    }
     
    

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

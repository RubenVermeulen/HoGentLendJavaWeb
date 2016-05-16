/*
 * All rights reserved.
 */
package controller;

import bean.FilterData;
import domain.Reservatie;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.ReservatieDao;

@Controller
public class FilterController {

    @Autowired
    private FilterData filterData;

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public String showFilterPage(Model model) {
        model.addAttribute(filterData);
        return "filter";
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public ModelAndView doFilter(@ModelAttribute("filterdata") FilterData data, Model model) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        try {
            date = formatter.parse(data.getDatum());
        } catch (ParseException e) {
            date = null;
        }
        if ((data.getDatum() != null && !data.getDatum().equals("")) && date == null){
            ModelAndView redirectModel = new ModelAndView("filter");
            redirectModel.addObject(data);
            redirectModel.addObject("datumError", "De datum moet dd/MM/yyyy als formaat hebben.");
            return redirectModel;
        }
        return new ModelAndView(
                "redirect:/reservaties/" + data.getSoortLijst(),
                "datum", date);
    }
}

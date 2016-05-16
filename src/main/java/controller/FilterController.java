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
import java.util.Calendar;
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
import util.Utils;

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
        Date date = Utils.stringToDate(data.getDatum());
        
        ModelAndView redirectModel = new ModelAndView("filter");
        redirectModel.addObject(data);
        if (data.getDatum() != null && data.getDatum().length() > 10){// database geeft errors als jaar > 9999
            redirectModel.addObject("datumError", String.format("De datum \"%s\" is niet geldig.", data.getDatum()));
            return redirectModel;
        }
        if (((data.getDatum() != null && !data.getDatum().equals("")) && date == null) || date != null){
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1);
            Date yesterday = cal.getTime();
            if (date == null){
                redirectModel.addObject("datumError", String.format("De datum \"%s\"is niet geldig.", data.getDatum()));
                return redirectModel;
            }else if ((yesterday).after(date)) {
                redirectModel.addObject("datumError", "De datum mag niet in het verleden liggen.");
                return redirectModel;
            }
        }
        return new ModelAndView(
                "redirect:/reservaties/" + data.getSoortLijst(),
                "datum", data.getDatum());
    }
}

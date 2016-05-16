/*
 * All rights reserved.
 */
package controller;

import bean.FilterData;
import domain.Reservatie;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println("DE DATA!!!!!b ------------- " + data.toString());
        
        return new ModelAndView(
            "redirect:/reservaties/" + filterData.getSoortLijst(),
            "filterdata", data);
    }
}

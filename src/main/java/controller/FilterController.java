/*
 * All rights reserved.
 */
package controller;

import bean.FilterData;
import domain.Reservatie;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FilterController {
    
    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public String showFilterPage(Model model) {
        model.addAttribute(new FilterData());
        return "filter";
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String doFilter(@ModelAttribute("filterdata") FilterData data, Model model) {
        System.out.println("DE DATA!!!!!b ------------- " + data.toString());
        model.addAttribute(data);
        return "filter";
    }
}

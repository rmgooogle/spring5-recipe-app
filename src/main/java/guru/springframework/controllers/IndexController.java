package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @RequestMapping({"","/","/index","xyindex"})
    public String getIndexPage(HttpServletRequest request, Model model){

        String welcomeMessage = "now in ";
        model.addAttribute("message",  request.getRequestURL().toString() );
        model.addAttribute("message2", welcomeMessage + request.getRequestURI());
        return "index";
    }
}

package com.controller;

import com.service.ICalisanService;
import com.service.IMadenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController{
    private final IMadenService madenService;
    private final ICalisanService calisanService;

    @Autowired
    public WebController(IMadenService madenService, ICalisanService calisanService) {
        this.madenService = madenService;
        this.calisanService = calisanService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listMadenler", madenService.listMaden());
        model.addAttribute("listCalisanlar", calisanService.listAllCalisan());
        return "blank";
    }

    /*@GetMapping("/hello2")
    @ResponseBody
    public String hello() {
        return "Hello World22";
    }

    @GetMapping({"/hello"})
    public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }*/

}

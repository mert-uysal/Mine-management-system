package com.controller;

import com.model.Maden;
import com.service.IMadenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MadenController {
    private final IMadenService madenService;

    @Autowired
    public MadenController(IMadenService madenService) {
        this.madenService = madenService;
    }

    @GetMapping("/showNewMadenForm")
    public String showNewMadenForm(Model model) {
        Maden maden = new Maden();
        model.addAttribute("maden", maden);
        return "maden_new";
    }

    @PostMapping("/saveMaden")
    public String saveMaden(@ModelAttribute("maden") Maden maden) {
        madenService.savemaden(maden);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String findMadenById(@PathVariable(value = "id") Integer id, Model model) {
        Maden maden = madenService.getMadenById(id);
        model.addAttribute("maden", maden);
        return "maden_edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteMaden(@PathVariable("id") Integer id) {
        this.madenService.deletemaden(id);
        return "redirect:/";
    }

}

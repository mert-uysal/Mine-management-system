package com.controller;

import com.model.Calisan;
import com.model.Maden;
import com.repository.CalisanRepository;
import com.service.ICalisanService;
import com.service.IMadenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@Controller
public class CalisanController {
    private final ICalisanService calisanService;
    private IMadenService madenService;
    private CalisanRepository repository;

    @Autowired
    public CalisanController(ICalisanService calisanService, IMadenService madenService) {
        this.calisanService = calisanService;
        this.madenService = madenService;
    }

    @GetMapping("/showNewCalisanForm")
    public String showNewCalisanForm(Model model) {
        Calisan calisan = new Calisan();
        model.addAttribute("calisan", calisan);
        return "calisan_new";
    }

    @PostMapping("/saveCalisan")
    public String savecalisan(Calisan calisan) {
        calisanService.savecalisan(calisan);
        return "redirect:/";
    }

    //Ad-Soyad editleme sayfasına yönlendirme
    @GetMapping("/showCalisanFormForUpdate/{id}")
    public String showEditFormCalisan(@PathVariable(value = "id") Integer id, Model model) {
        Calisan calisan = calisanService.getCalisanById(id);
        model.addAttribute("calisan", calisan);
        return "calisan_edit";
    }

    //ad-soyad editleme işlemi
    @PostMapping("/update/{id}")
    public String updateCalisan(@PathVariable(value = "id") Integer id, @Valid Calisan calisan, BindingResult result, Model model){
        if(result.hasErrors()){
            calisan.setId(id);
            return "calisan_edit";
        }
        calisanService.savecalisan(calisan);
        model.addAttribute("calisan", calisanService.listAllCalisan());
        return "redirect:/";
    }

    //Maden ekleme sayfasına yönlendirme
    @GetMapping("/addCalisanaMaden/{id}")
    public String addCalisanaMaden(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("madenler", madenService.listMaden());
        model.addAttribute("calisan", calisanService.getCalisanById(id));
        return "calisan_addMaden";
    }

    //eklenen madenleri kaydetme işlemi
    @GetMapping("/calisan/{id}/madenler")
    public String calisanAddMaden(@PathVariable Integer id, @RequestParam Integer madenId, Model model) {
        Maden maden = madenService.getMadenById(madenId);
        Calisan calisan = calisanService.getCalisanById(id);
        if (calisan != null) {
            calisan.getMadenler().add(maden);
            calisanService.savecalisan(calisan);
            //model.addAttribute("calisan", madenService.getMadenById(id));
            //model.addAttribute("madenler", madenService.listMaden());
            return "redirect:/addCalisanaMaden/{id}";
        }
        return "redirect:/addCalisanaMaden/{id}";
    }

    @GetMapping("/deleteCalisan/{id}")
    public String deletecalisan(@PathVariable("id") Integer id) {
        this.calisanService.deletecalisan(id);
        return "redirect:/";
    }

}

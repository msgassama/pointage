package com.groupeisi.pointage.controller;

import com.groupeisi.pointage.entity.Professeur;
import com.groupeisi.pointage.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

/**
 * @author MS GASSAMA
 */
@Controller
public class ProfesseurController {

    @Autowired
    private ProfesseurRepository professeurRepository;


    @GetMapping({"/professeur/all", "/"})
    public String all(ModelMap modelMap){
        List<Professeur> professeurs = professeurRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        modelMap.addAttribute("professeurs", professeurs);
        return "professeur/all";
    }

    @GetMapping(value = "/professeur/add")
    public String add(ModelMap modelMap){
        Professeur professeur = new Professeur();
        modelMap.addAttribute("professeur", professeur);
        return "professeur/add";
    }

    @RequestMapping(value = "/professeur/save", method = RequestMethod.POST)
    public String save(Professeur professeur, RedirectAttributes redirectAttributes) {
        professeurRepository.save(professeur);
        redirectAttributes.addFlashAttribute("message", "Professeur enregistré avec succés");
        return "redirect:/professeur/all";
    }

    @GetMapping("/professeur/edit/{id}")
    public String update(@PathVariable Long id, ModelMap modelMap){
        Optional<Professeur> professeur = professeurRepository.findById(id);
        modelMap.addAttribute("professeur", professeur);
        return "professeur/add";
    }

    @GetMapping("/professeur/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        professeurRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Professeur supprimé avec succés.");
        return "redirect:/";
    }

}

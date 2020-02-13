package com.bartrzym.wateringplan.controller;

import com.bartrzym.wateringplan.entity.Client;
import com.bartrzym.wateringplan.entity.Nozzle;
import com.bartrzym.wateringplan.repo.NozzleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NozzleController {

    private final NozzleRepo nozzleRepo;

    @Autowired
    public NozzleController(NozzleRepo nozzleRepo) {
        this.nozzleRepo = nozzleRepo;
    }

    @GetMapping("/nozzle")
    public String sayHello(Model model) {
        if (nozzleRepo.count() > 0) {
            model.addAttribute("nozzles", nozzleRepo.findAll());
        }
        return "nozzle/index";
    }

    @GetMapping("/nozzle/add")
    public String showSignUpForm(Nozzle nozzle) {
        return "nozzle/add-nozzle";
    }

    @PostMapping("/nozzle/addnozzle")
    public String addUser(Nozzle nozzle, BindingResult result, Model model) {
        model.addAttribute("nozzles", nozzleRepo.findAll());
        if (result.hasErrors()) {
            return "nozzle/add-nozzle";
        }
        if (!nozzleRepo.existsClientByName(nozzle.getName()) & !nozzle.getName().equals("")) {
            nozzleRepo.save(nozzle);
            model.addAttribute("nozzles", nozzleRepo.findAll());
            return "nozzle/index";

        }

        return "nozzle/index";
    }

    @GetMapping("/nozzle/delete/{id}")
    public String deleteClient(@PathVariable Long id, Model model) {
        nozzleRepo.deleteById(id);
        model.addAttribute("nozzles", nozzleRepo.findAll());
        return "nozzle/index";

    }
}


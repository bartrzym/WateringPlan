package com.bartrzym.wateringplan.controller;

import com.bartrzym.wateringplan.entity.Client;
import com.bartrzym.wateringplan.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {

    private final ClientRepo clientRepo;

    @Autowired
    public ClientController(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;

    }

    @GetMapping
    public String sayHello(Model model) {
        if (clientRepo.count() > 0) {
            model.addAttribute("clients", clientRepo.findAll());
        }
        return "index";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Client client) {
        return "add-client";
    }

    @PostMapping("/addclient")
    public String addUser(Client client, BindingResult result, Model model) {
        model.addAttribute("clients", clientRepo.findAll());
        if (result.hasErrors()) {
            return "add-client";
        }
        if (!clientRepo.existsClientByName(client.getName()) & !client.getName().equals("")) {
            clientRepo.save(client);
            model.addAttribute("clients", clientRepo.findAll());
            return "index";

        }

        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id, Model model) {
        clientRepo.deleteById(id);
        model.addAttribute("clients", clientRepo.findAll());
        return "index";

    }

    // additional CRUD methods
}


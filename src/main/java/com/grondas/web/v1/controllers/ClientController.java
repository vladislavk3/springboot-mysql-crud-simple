package com.grondas.web.v1.controllers;

import com.grondas.services.v1.ClientService;
import com.grondas.web.v1.model.ClientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(ClientController.BASE_URL)
public class ClientController {

    public static final String BASE_URL = "/v1/clients";
    @Autowired
    private ClientService clientService;

    ///////////////////// GET MAPPINGS /////////////////////

    @GetMapping
    public String findAll(Model model) {

        List<ClientDTO> objects = clientService.findAll();

        model.addAttribute("objects", objects);

        return "client/list";
    }

    @GetMapping("{id}")
    public String findDtoById(@PathVariable long id, Model model) {
        model.addAttribute("objects", clientService.findDtoById(id));
        return "transfer/transfer-list";
    }

    @GetMapping("/create")
    public String initCreationForm(Model model) {

        model.addAttribute("object", new ClientDTO());

        return "client/creation-form";
    }

    ///////////////////// POST MAPPINGS /////////////////////

    @PostMapping("/create")
    public String saveOrUpdate(@ModelAttribute ClientDTO objectDTO) {

        clientService.createNewObject(objectDTO);

        return "redirect:/v1/clients";
    }

    @PostMapping("/update")
    public String initUpdateForm(@RequestParam("objectId")long id, Model model) {

        model.addAttribute("object", clientService.findDtoById(id));

        return "client/creation-form";
    }

    @PostMapping("/delete")
    public String deleteObject(@RequestParam("objectId")long id) {
        clientService.deleteById(id);
        return "redirect:/v1/clients";
    }
}
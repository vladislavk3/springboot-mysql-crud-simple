package com.grondas.web.v1.controllers;

import com.grondas.services.v1.VehicleService;
import com.grondas.web.v1.model.VehicleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(VehicleController.BASE_URL)
public class VehicleController {

    public static final String BASE_URL = "/v1/vehicles";
    @Autowired
    private VehicleService vehicleService;

    ///////////////////// GET MAPPINGS /////////////////////

    @GetMapping
    public String findAll(Model model) {

        List<VehicleDTO> objects = vehicleService.findAll();

        model.addAttribute("objects", objects);

        return "vehicle/list";
    }

//    @GetMapping("{id}")
//    public String findDtoById(@PathVariable long id, Model model) {
//        model.addAttribute("objects", clientService.findDtoById(id));
//        return "transfer/transfer-list";
//    }

    @GetMapping("/create")
    public String initCreationForm(Model model) {

        model.addAttribute("object", new VehicleDTO());

        return "vehicle/add-update-form";
    }


    @PostMapping("/create")
    public String saveOrUpdate(@ModelAttribute VehicleDTO objectDTO) {

        vehicleService.createNewObject(objectDTO);

        return "redirect:/v1/vehicles";
    }

//    @PostMapping("/update")
//    public String initUpdateForm(@RequestParam("objectId")long id, Model model) {
//
//        model.addAttribute("object", clientService.findDtoById(id));
//
//        return "client/creation-form";
//    }
//
    @PostMapping("/delete")
    public String deleteObject(@RequestParam("objectId")long id) {
        vehicleService.deleteById(id);
        return "redirect:/v1/vehicles";
    }
}
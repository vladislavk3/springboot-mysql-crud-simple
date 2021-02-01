package com.grondas.web.v1.controllers;

import com.grondas.services.v1.DriverService;
import com.grondas.services.v1.FuelRefillService;
import com.grondas.services.v1.VehicleService;
import com.grondas.web.v1.model.FuelRefillDTO;
import com.grondas.web.v1.model.VehicleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(FuelRefillController.BASE_URL)
public class FuelRefillController {

    public static final String BASE_URL = "/v1/fuelRefills";
    @Autowired
    private FuelRefillService fuelRefillService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private VehicleService vehicleService;

    ///////////////////// GET MAPPINGS /////////////////////

    @GetMapping
    public String findAll(Model model) {

        List<FuelRefillDTO> objects = fuelRefillService.findAll();

        model.addAttribute("objects", objects);

        return "fuelRefill/list";
    }

//    @GetMapping("{id}")
//    public String findDtoById(@PathVariable long id, Model model) {
//        model.addAttribute("objects", clientService.findDtoById(id));
//        return "transfer/transfer-list";
//    }

    @GetMapping("/create")
    public String initCreationForm(Model model) {

        model.addAttribute("object", new FuelRefillDTO());
        model.addAttribute("driverList", driverService.findAll());
        model.addAttribute("vehicleList", vehicleService.findAll());

        return "fuelRefill/add-update-form";
    }


    @PostMapping("/create")
    public String saveOrUpdate(@ModelAttribute FuelRefillDTO objectDTO) {

        fuelRefillService.createNewObject(objectDTO);

        return "redirect:/v1/fuelRefills";
    }

//    @PostMapping("/update")
//    public String initUpdateForm(@RequestParam("objectId")long id, Model model) {
//
//        model.addAttribute("object", clientService.findDtoById(id));
//
//        return "client/creation-form";
//    }
//
//    @PostMapping("/delete")
//    public String deleteObject(@RequestParam("objectId")long id) {
//        clientService.(id);
//        return "redirect:/v1/clients";
//    }
}
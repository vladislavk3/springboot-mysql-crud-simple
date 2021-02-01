package com.grondas.web.v1.controllers;

import com.grondas.services.v1.DriverService;
import com.grondas.services.v1.FuelRefillService;
import com.grondas.web.v1.model.DriverDTO;
import com.grondas.web.v1.model.FuelRefillDTO;
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
@RequestMapping(DriverController.BASE_URL)
public class DriverController {

    ///////////////////// Injections /////////////////////

    public static final String BASE_URL = "/v1/drivers";
    @Autowired
    private DriverService driverService;
    @Autowired
    private FuelRefillService fuelRefillService;

    ///////////////////// FIND MAPPINGS /////////////////////

    @GetMapping
    public String findAll (Model model) {
        List<DriverDTO> drivers = driverService.findAll();
        model.addAttribute("drivers", drivers);
        return "driver/list";
    }

    @GetMapping("/transfer")
    public String findTransferByUserName(Model model) {
        return "driver/transfer-list";
    }

    @GetMapping("/fuelRefills")
    public String findRefillsByUserName(Model model) {
        List<FuelRefillDTO> listDto = fuelRefillService.findAllByUserName();
        model.addAttribute("objects", listDto);
        return "/driver/refill-list";
    }

    ///////////////////// CREATE MAPPINGS /////////////////////

    @GetMapping("/create")
    public String initDriverCreation(Model model) {
        model.addAttribute("driver", new DriverDTO());
        return "driver/add-update-form";
    }

    @PostMapping("/create")
    public String saveOrUpdate(@ModelAttribute DriverDTO driverDTO) {
        driverService.createNewObject(driverDTO);
        return "redirect:/v1/drivers";
    }

}

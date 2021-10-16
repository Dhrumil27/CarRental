package com.dhrumil.CarRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dhrumil.CarRental.service.CarService;

public class StartController {
	
	@Autowired
	private CarService service;
	
    @GetMapping({"/"})
    public String main(Model model) {
        return "index";
    }
}

package com.geekster.restaurantManagementServiceAPI.controllers;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.geekster.restaurantManagementServiceAPI.models.Food;
import com.geekster.restaurantManagementServiceAPI.services.ViewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/viewer")
public class ViewerController {
    @Autowired
    ViewerService viewerService;
    @GetMapping("/menu")
    public List<Food>getMenu(){
        return viewerService.getMenu();
    }
}

package com.test.demo.controller;

import com.test.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/find")
    public List<String> findCitiesStartingWithLetter(@RequestParam("letter") String letter) {
        List<String> allCities = cityService.findCityStartingWith(letter);
        return allCities;
    }
}

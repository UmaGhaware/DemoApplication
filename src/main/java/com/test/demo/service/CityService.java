package com.test.demo.service;


import com.test.demo.dto.CityDetails;
import com.test.demo.dto.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private RestTemplate restTemplate;

    

    public List<CityDetails> getAll() {
        ResponseEntity<Details> response = restTemplate.getForEntity("https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=b6907d289e10d714a6e88b30761fae22", Details.class);
        Details body = response.getBody();
        System.out.println(body);
        return body.getList();
    }

    public List<String> findCityStartingWith(String letter) {
        List<CityDetails> all = this.getAll();
        List<String> collect = all.stream().map(ele -> ele.getName().toUpperCase()).filter(ele -> ele.startsWith(letter.toUpperCase())).collect(Collectors.toList());
        return collect;
    }
}

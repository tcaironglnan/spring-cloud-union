package com.cloud.docker.controller;

import com.cloud.docker.model.City;
import com.cloud.docker.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/editCity")
    public City editCity(@RequestBody City city){
        return cityService.editCity(city);
    }

    @PostMapping("/save")
    public City save(@RequestBody City city){
        return cityService.save(city);
    }

    @GetMapping("/deleteUserById")
    public City deleteUserById(Long id){
        return cityService.delete(new City().setId(id));
    }

    @PostMapping("/delete")
    public City delete(@RequestBody City city){
        return cityService.delete(city);
    }

    @GetMapping("/findCityById/{id}")
    public City findCityById(@PathVariable Long id){
        return cityService.findCityById(id);
    }

    @RequestMapping("find")
    public List<City> findAll(ModelMap model) {
        List<City> all = cityService.findAll();
        model.addAttribute("all", all);
        return all;
    }

    @PostMapping("/getPage")
    public Page<City> getPage(String name, Integer currentPage, Integer pageSize) {
        Page<City> page = cityService.cityList(new City().setName(name), currentPage, pageSize);
        return page;
    }

    @PostMapping("/query")
    public Page<City> query(String name, Integer currentPage, Integer pageSize) {
        Page<City> page = cityService.findCityByLikeNameList(new City().setName(name), currentPage, pageSize);
        return page;
    }

    @PostMapping("/search")
    public Page<City> search(String name, Integer currentPage, Integer pageSize) {
        Page<City> page = cityService.search(new City().setName(name), currentPage, pageSize);
        //分页内容
        List<City> content = page.getContent();
        //总页数
        int totalPages = page.getTotalPages();
        //总条数
        long total = page.getTotalElements();
        //当前页
        int number = page.getNumber() + 1;
        //每页显示数
        int size = page.getSize();
        //总页数
        return page;
    }
}
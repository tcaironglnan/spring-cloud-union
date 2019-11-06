package com.cloud.docker.service;

import com.cloud.docker.model.City;
import com.cloud.docker.tools.Page;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-06-04 9:18
 **/
public interface CityService {

    Page<City> search(String cityName, Integer currentPage, Integer pageSize);

    boolean editCity(City city);

    City findCityById(Long id);

    Page<City> cityList(Integer pageSize, Integer currentPage);

    List<City> findAll();
}

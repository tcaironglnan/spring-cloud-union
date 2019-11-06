package com.cloud.docker.dao;

import com.cloud.docker.model.City;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-06-04 9:16
 **/
@Repository
public interface CityRepository {

    List<City> search(String cityName);

    boolean editCity(City city);

    City findCityById(Long id);

    List<City> findAll();
}

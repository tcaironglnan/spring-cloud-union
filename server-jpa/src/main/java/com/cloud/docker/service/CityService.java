package com.cloud.docker.service;

import com.cloud.docker.model.City;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-06-04 9:18
 **/
public interface CityService {

    Page<City> search(City city, Integer currentPage, Integer pageSize);

    City editCity(City city);

    City save(City city);

    City delete(City city);

    City findCityById(Long id);

    /**
     * 精确查询
     * @param city
     * @param currentPage
     * @param pageSize
     * @return
     */
    Page<City> cityList(City city, Integer currentPage, Integer pageSize);

    /**
     * 模糊查询
     * @param city
     * @param currentPage
     * @param pageSize
     * @return
     */
    Page<City> findCityByLikeNameList(City city, Integer currentPage, Integer pageSize);

    List<City> findAll();
}

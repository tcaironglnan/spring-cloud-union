package com.cloud.docker.service.impl;

import com.cloud.docker.dao.CityRepository;
import com.cloud.docker.model.City;
import com.cloud.docker.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-06-04 9:19
 **/
@Service("cityService")
public class CityServiceImpl implements CityService {

    private static final Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);
    @Autowired
    private CityRepository cityRepository;

    /**
     * 常规分页查询
     * @param city
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page<City> search(City city, Integer currentPage, Integer pageSize) {
        //排序
        List<Sort.Order> sortList = new ArrayList<>();
        sortList.add(new Sort.Order(Sort.Direction.ASC, "id"));
        Sort sort = new Sort(sortList);
        //分页
        PageRequest request = new PageRequest(currentPage - 1, pageSize, sort);
        //查询条件
        //模糊查询
//        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name" ,ExampleMatcher.GenericPropertyMatchers.contains());//全部模糊查询，即%{address}%
        //.withIgnorePaths("password");//忽略字段，即不管password是什么值都不加入查询条件
//        Example<City> cityExample = Example.of(city,matcher);
        Example<City> cityExample = Example.of(city);
        //执行查询
        return cityRepository.findAll(cityExample, request);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 3600, rollbackFor = Exception.class)
    @Override
    public City editCity(City city) {
        return cityRepository.saveAndFlush(city);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 3600, rollbackFor = Exception.class)
    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 3600, rollbackFor = Exception.class)
    @Override
    public City delete(City city) {
        try {
            cityRepository.delete(city);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public City findCityById(Long id) {
        return cityRepository.findOne(id);
    }

    /**
     * //分页查询 + 动态条件 + nativeQuery = true,如果多个条件查询时，有条件添加进去了，但为空条件为空会报: Page 1 of 0 containing UNKNOWN instances
     * @param city
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page<City> cityList(City city, Integer currentPage, Integer pageSize) {

        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == null || pageSize == 0) {
            pageSize = 10;
        }
        List<Sort.Order> olist = new ArrayList<>();
        olist.add(new Sort.Order(Sort.Direction.ASC, "id"));
        Sort sort = new Sort(olist);
        Pageable pageable = new PageRequest(currentPage - 1, pageSize, sort);
        Page<City> query = cityRepository.findPageIfAgeNotNullNativeQuery(city.getName(), pageable);
        return query;
    }

    /**
     * 模糊查询
     * @param city
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page<City> findCityByLikeNameList(City city, Integer currentPage, Integer pageSize) {
        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == null || pageSize == 0) {
            pageSize = 10;
        }
        List<Sort.Order> olist = new ArrayList<>();
        olist.add(new Sort.Order(Sort.Direction.ASC, "id"));
        Sort sort = new Sort(olist);
        Pageable pageable = new PageRequest(currentPage - 1, pageSize, sort);
        Page<City> pageByNameLike = cityRepository.findPageByNameLike(city.getName(), pageable);
        return pageByNameLike;
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }
}

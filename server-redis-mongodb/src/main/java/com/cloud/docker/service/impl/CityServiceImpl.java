package com.cloud.docker.service.impl;

import com.cloud.docker.dao.CityRepository;
import com.cloud.docker.model.City;
import com.cloud.docker.service.CityService;
import com.cloud.docker.tools.Page;
import com.cloud.docker.tools.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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


    @Override
    public Page<City> search(String cityName, Integer currentPage, Integer pageSize) {

        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == null || pageSize == 0) {
            pageSize = 10;
        }

        try {
            PageHelper.startPage(currentPage, pageSize);
            List<City> search = cityRepository.search(cityName);
            PageInfo<City> pageInfo = new PageInfo<>(search);
            return PageUtil.page(pageInfo);
        } catch (Exception e) {
            logger.error("查询数据出错,错误信息是:", e);
            return Page.defaultPage();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 3600, rollbackFor = Exception.class)
    @Override
    public boolean editCity(City city) {
        return cityRepository.editCity(city);
    }

    @Override
    public City findCityById(Long id) {
        return cityRepository.findCityById(id);
    }

    @Override
    public Page<City> cityList(Integer pageSize, Integer currentPage) {

        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == null || pageSize == 0) {
            pageSize = 10;
        }

        try {
            PageHelper.startPage(currentPage, pageSize);
            List<City> userList = cityRepository.findAll();
            PageInfo pageInfo = new PageInfo(userList);
            return PageUtil.page(pageInfo);
        } catch (Exception e) {
            logger.error("查询数据出错,错误信息是:", e);
            return null;
        }
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }
}

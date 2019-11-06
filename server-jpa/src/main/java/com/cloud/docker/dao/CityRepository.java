package com.cloud.docker.dao;

import com.cloud.docker.model.City;
import com.cloud.docker.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 暂时还无法解决传入对象查询的报错问题
 * @author FaceFeel
 * @Created 2018-06-04 9:16
 **/
@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    //分页查询 + 动态条件 + nativeQuery = true,如果多个条件查询时，有条件添加进去了，但为空条件为空会报: Page 1 of 0 containing UNKNOWN instances,,返回的是初始化的Page对象,也就是查询不到结果
    @Query(value = "select * from city s where (?1=null or s.name=?1) order by ?#{#pageable}",nativeQuery = true)
    Page<City> findPageIfAgeNotNullNativeQuery(String name, Pageable pageable);

    //模糊查询: ,如果多个条件查询时，有条件添加进去了，但为空条件为空会报: Page 1 of 0 containing UNKNOWN instances,返回的是初始化的Page对象,也就是查询不到结果
    @Query(nativeQuery = true, value = "select * from city c where c.name like CONCAT('%',?1,'%') order by ?#{#pageable}")
    Page<City> findPageByNameLike(String name, Pageable pageable);
}

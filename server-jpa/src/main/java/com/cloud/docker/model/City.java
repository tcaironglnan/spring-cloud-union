package com.cloud.docker.model;

import com.google.common.base.MoreObjects;

import javax.persistence.*;

/**
 * @author FaceFeel
 * @Created 2018-04-17 13:21
 **/
@Entity
public class City implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String countryCode;
    @Column
    private String district;
    @Column
    private Long population;


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("countryCode", countryCode)
                .add("district", district)
                .add("population", population)
                .toString();
    }

    public Long getId() {
        return id;
    }

    public City setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public City setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public City setDistrict(String district) {
        this.district = district;
        return this;
    }

    public Long getPopulation() {
        return population;
    }

    public City setPopulation(Long population) {
        this.population = population;
        return this;
    }
}

package com.cloud.docker.model;

import com.google.common.base.MoreObjects;

import java.math.BigDecimal;

/**
 * @author Lenovo
 * @Created 2019-10-08 17:20
 **/
//@Entity
public class User implements java.io.Serializable{

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @Column
    private String username;
//    @Column
    private String name;
//    @Column
    private Integer age;
//    @Column
    private BigDecimal balance;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("username", username)
                .add("name", name)
                .add("age", age)
                .add("balance", balance)
                .toString();
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public User setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }
}

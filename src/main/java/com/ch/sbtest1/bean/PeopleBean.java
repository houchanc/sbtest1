package com.ch.sbtest1.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationProperties(prefix = "com.ch")
public class PeopleBean {
    @Value("${com.ch.name}")
    private String name;
    @Value("${com.ch.want}")
    private String want;

    public String getName() {
        return name;
    }

    public String getWant() {
        return want;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWant(String want) {
        this.want = want;
    }
}

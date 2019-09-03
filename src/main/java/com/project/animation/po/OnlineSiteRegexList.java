package com.project.animation.po;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Primary
@Configuration
@ConfigurationProperties(prefix = "animation")
@PropertySource(value = {"classpath:onlineSite.properties"})
@EnableConfigurationProperties(OnlineSiteRegexList.class)
public class OnlineSiteRegexList {

    private List<OnlineSiteRegex> regexes = new ArrayList<>();

    public List<OnlineSiteRegex> getRegexes() {
        return regexes;
    }

    public void setRegexes(List<OnlineSiteRegex> regexes) {
        this.regexes = regexes;
    }
}

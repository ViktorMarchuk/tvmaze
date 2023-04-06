package com.epam.tvmaze.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TVShow {
    private int id;
    private String url;
    private String name;
    private WebChannel webChannel;
    private Links _links;
}
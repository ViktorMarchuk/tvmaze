package com.epam.tvmaze.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(includeFieldNames = true)
public class TVShow {
    private int id;
    private String url;
    private String name;
    private WebChannel webChannel;
    private Links _links;
    private PreviousEpisode previousepisode;
}
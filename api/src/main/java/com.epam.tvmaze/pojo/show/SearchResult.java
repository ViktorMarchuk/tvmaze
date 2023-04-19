package com.epam.tvmaze.pojo.show;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(includeFieldNames = true)
public class SearchResult {
    @JsonProperty("show")
    private TVShow tvShow;
}
package com.epam.tvmaze.pojo.show;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(includeFieldNames = true)
public class Links {
    private PreviousEpisode previousepisode;
}

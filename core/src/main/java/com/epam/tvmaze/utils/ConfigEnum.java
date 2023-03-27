package com.epam.tvmaze.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConfigEnum {
    EMAIL("email"),
    PASSWORD("password"),
    BASE_URL("baseUrl"),
    API_URL("apiUrl"),
    BROWSER("browser");
    private final String param;
}

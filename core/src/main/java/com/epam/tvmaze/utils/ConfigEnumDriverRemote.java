package com.epam.tvmaze.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConfigEnumDriverRemote {
    DRIVER_REMOTE("driverRemote"),
    USER_NAME("username"),
    ACCESS_KEY("accessKey"),
    BROWSER_NAME("browserName"),
    BROWSER_VERSION("browserVersion"),
    PLATFORM("platform"),
    BUILD_NAME("buildName"),
    LT_URL("lt_url");
    private final String param;
}

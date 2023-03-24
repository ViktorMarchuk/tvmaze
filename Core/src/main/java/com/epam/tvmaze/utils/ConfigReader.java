package com.epam.tvmaze.utils;

import java.util.ResourceBundle;

public class ConfigReader {
    private static final ResourceBundle rb = ResourceBundle.getBundle("config");

    public static String getValue(ConfigEnum configEnum) {
        String result = rb.getString(configEnum.getParam());
        return result;
    }
}

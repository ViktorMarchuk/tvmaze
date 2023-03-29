package com.epam.tvmaze.utils;

import java.util.ResourceBundle;

public class ConfigReaderApiProperties{
    public static String getValueProperties(String nameProperties, String valueProperties){
        ResourceBundle config = ResourceBundle.getBundle(nameProperties);
        String value = config.getString(valueProperties);

        return value;
    }
}
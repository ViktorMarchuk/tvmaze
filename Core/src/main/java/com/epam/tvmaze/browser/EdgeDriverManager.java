package com.epam.tvmaze.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static io.github.bonigarcia.wdm.config.DriverManagerType.EDGE;

public class EdgeDriverManager implements DriverManager {
    private final EdgeOptions edgeOptions = new EdgeOptions();

    @Override
    public WebDriver createDriver() {
        WebDriverManager.getInstance(EDGE).setup();
        setEdgeOptions();
        return new EdgeDriver(edgeOptions);
    }

    private void setEdgeOptions() {
        edgeOptions.addArguments("--lang=en-US");
    }
}

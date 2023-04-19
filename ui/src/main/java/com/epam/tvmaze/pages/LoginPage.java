package com.epam.tvmaze.pages;

import com.epam.tvmaze.utils.ConfigEnum;
import com.epam.tvmaze.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HomePage {
    @FindBy(id = "loginform-username")
    private WebElement fieldUserName;
    @FindBy(id = "loginform-password")
    private WebElement fieldPassword;
    @FindBy(xpath = "//form[@id='w0']/button")
    private WebElement buttonLogin;

    @Override
    public LoginPage openPage() {
        driver.navigate().to(ConfigReader.getValue(ConfigEnum.BASE_URL));
        return this;
    }

    public LoginPage inputUserName() {
        fieldUserName.sendKeys(ConfigReader.getValue(ConfigEnum.EMAIL));
        return this;
    }

    public LoginPage inputPassword() {
        fieldPassword.sendKeys(ConfigReader.getValue(ConfigEnum.PASSWORD));
        return this;
    }

    public HomePage clickButtonLogin() {
        buttonLogin.click();
        return new HomePage();
    }
}
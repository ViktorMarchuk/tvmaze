package com.epam.tvmaze.pages;

import com.epam.tvmaze.utils.ConfigEnum;
import com.epam.tvmaze.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HomePage {

  @FindBy(xpath = "//div[@id='user-tools']//a[@href='/account/login']")
  private WebElement fieldLogin;
  @FindBy(id = "loginform-username")
  private WebElement fieldUserName;
  @FindBy(id = "loginform-password")
  private WebElement fieldPassword;
  @FindBy(xpath = "//form[@id='w0']/button")
  private WebElement buttonLogin;

  public void clickFieldLogin() {
    fieldLogin.click();
  }

  public void inputUserName() {
    fieldUserName.sendKeys(ConfigReader.getValue(ConfigEnum.EMAIL));
  }

  public void inputPassword() {
    fieldPassword.sendKeys(ConfigReader.getValue(ConfigEnum.PASSWORD));
  }

  public void clickButtonLogin() {
    buttonLogin.click();
  }
}

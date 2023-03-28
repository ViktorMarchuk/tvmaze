package ui;

import com.epam.tvmaze.driver.Driver;
import com.epam.tvmaze.pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void openPage() {
        new HomePage().openPage();
    }

    @AfterMethod
    public void closeWebDriver() {
        Driver.closeDriver();
    }
}

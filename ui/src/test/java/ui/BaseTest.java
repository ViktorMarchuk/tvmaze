package ui;

import com.epam.tvmaze.driver.Driver;
import com.epam.tvmaze.pages.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    @BeforeClass
    public void openPage() {
        new HomePage().openPage();
    }

    @AfterClass(alwaysRun = true)
    public void closeWebDriver() {
        Driver.closeDriver();
    }
}

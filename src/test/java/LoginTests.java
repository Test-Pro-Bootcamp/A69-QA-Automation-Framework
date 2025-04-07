import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {


    @Test
    public void loginSucceedTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.enterEmail("planner@testpro.io");
        loginPage.enterPassword("6JooL8gp");
        loginPage.clickLoginBtn();
        // find if avatar exists
        Assert.assertTrue(homePage.isAvatarDisplayed());
    }

    @Test
    public void loginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("demo@class.com");
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.isSubmitBtnDisplayed());
    }

    @Test
    public void loginInvalidEmailTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("notexists@class.com","te$t$tudent");
        Assert.assertFalse(loginPage.isSubmitBtnDisplayed());
    }
}

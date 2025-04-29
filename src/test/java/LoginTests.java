import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


    public class LoginTests extends BaseTest {
    @Test(enabled = false, description = "Test has been marked as skipped due to an issue in Jira-124111")

    public void loginValidEmailPassword() {

        navigateToPage();
        provideEmail("zhamilia.begalieva@testpro.io");
        providePassword("GaeuncKV");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url); // asserting that website url stays the same
        WebElement avatarIcon = driver.findElement(By.xpath("//img[@class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test(priority = 1)
    public void loginInvalidEmailValidPassword() {
        navigateToPage();
        provideEmail("invalid@testpro.ca");
        providePassword("GaeuncKV");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url); // asserting that website url stays the same

    }

    @Test
    public void loginValidEmailEmptyPassword() {
        navigateToPage();
        provideEmail("zhamilia.begalieva@testpro.io");
        providePassword("");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url); // asserting that website url stays the same

    }

}

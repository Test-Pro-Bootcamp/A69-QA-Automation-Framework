import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(dataProvider ="IncorrectLoginData", dataProviderClass = BaseTest.class)
    public void loginInvalidEmailValidPassword(String email, String password) {

        navigateToPage();
        provideEmail(email);
        providePassword(password);
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url); // asserting that website url stays the same

    }
    @Test(enabled = false, description = "Test has been marked as skipped due to am issue in Jira-124111")
    public void loginValidEmailPassword() {

        navigateToPage();
        provideEmail("zhamilia.begalieva@testpro.io");
        providePassword("GaeuncKV");
        clickSubmit();

// error in a
      Assert.assertEquals(driver.getCurrentUrl(), url); // asserting that website url stays the same
        WebElement avatarIcon = driver.findElement(By.xpath("//img[@class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());

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

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegistrationTests extends BaseTest {

    @Test
    public void successAccountRegistrationTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmail("artemisia.chalkiopoulou@testpro.io");
        registrationPage.clickSubmitBtn();
    }

    @Test
    public void alreadyRegisteredEmailTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmail("artemisia.chalkiopoulou@testpro.io"); // Ensure this exists in DB
        registrationPage.clickSubmitBtn();
        Assert.assertEquals(registrationPage.getErrorMessage(), "user already registered");
    }

    @Test
    public void invalidEmailFormat_NoAtSymbolTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmail("artemisia.chalkiopouloutestpro.io");
        registrationPage.clickSubmitBtn();
        Assert.assertEquals(registrationPage.getErrorMessage(), "Please include a '@' in the email address. 'artemisia.chalkiopouloutestpro.io' is missing am '@'");
    }

    @Test
    public void invalidPasswordFormat_NoDotAfterAtSymbolTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmail("artemisia.chalkiopoulou@testproio");
        registrationPage.clickSubmitBtn();
        Assert.assertEquals(registrationPage.getErrorMessage(), "Sorry, only certain emails are allowed, please do not use your personal email");
    }

    @Test
    public void invalidEmailFormat_WrongDomainTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmail("artemisia.chalkiopoulou@email.com");
        registrationPage.clickSubmitBtn();
        Assert.assertEquals(registrationPage.getErrorMessage(), "Sorry, only certain emails are allowed, please do not use your personal email");
    }

    @Test
    public void plusSignOneNotAllowedBeforeAtTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmail("artemisia.chalkiopoulou+1@testpro.io");
        registrationPage.clickSubmitBtn();
    }

    @Test
    public void plusSignThreeNotAllowedBeforeAtTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmail("artemisia+3.chalkiopoulou@testpro.io");
        registrationPage.clickSubmitBtn();
    }

    @Test
    public void successLoginAfterRegistrationTest() {
        LoginPage login = new LoginPage(driver);
        login.provideEmail("artemisia.chalkiopoulou@testpro.io");
        login.providePassword("Artemis@testpro2025");
        login.clickLoginBtn();
    }
}

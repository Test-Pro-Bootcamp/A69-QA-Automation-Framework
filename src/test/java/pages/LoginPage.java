package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By submitLogin = By.cssSelector("button[type='submit']");
    By passwordInput = By.cssSelector("[type='password']");
    By emailInput = By.cssSelector("[type='email']");

    public void clickLoginBtn() {
        driver.findElement(submitLogin).click();
    }

    public boolean isSubmitBtnDisplayed(){
        return driver.findElement(submitLogin).isDisplayed();
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        driver.findElement(passwordInput).click();
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void enterEmail(String email) {
        ExpectedConditions.visibilityOfElementLocated(emailInput);
        driver.findElement(emailInput).click();
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void login(String emailAddress, String psw){
        enterEmail(emailAddress);
        enterPassword(psw);
        clickLoginBtn();
    }


}

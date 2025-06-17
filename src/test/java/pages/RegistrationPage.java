package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "input[type='email']")
    WebElement emailField;
    @FindBy(css = "button[type='submit']")
    WebElement clickSubmit;
    @FindBy(css = "input[type='password']")

    By errorMsg = By.cssSelector(".error");

    public RegistrationPage enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public RegistrationPage clickSubmitBtn() {
        clickSubmit.click();
        return this;
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }
}

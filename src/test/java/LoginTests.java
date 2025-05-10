import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginTests extends BaseTest {
    @Test
    public void loginValidEmailPassword() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Steps
        String url ="https://qa.koel.app/";
        driver.get(url);

        //Assert.assertEquals(driver.getCurrentUrl(), url);
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.sendKeys("julia.munoz@testpr.io");

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.clear();
        passwordField.sendKeys("Ltdan25!");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        WebElement avatarIcon=driver.findElement(By.xpath("//img[@class='avatar']"));
        //Expected Result
        Assert.assertTrue(avatarIcon.isDisplayed());

        driver.quit();
    }
    @Test
    public void loginInvalidEmailValidPassword() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Steps
        String url = "https://qa.koel.app/";
        driver.get(url);


        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.sendKeys("invalid@testpr.ca");

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.clear();
        passwordField.sendKeys("Ltdan25!");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
    @Test
    public void loginValidEmailInvalidPassword() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Steps
        String url = "https://qa.koel.app/";
        driver.get(url);


        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.sendKeys("julia.munoz@testpro.io");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.clear();
        password.sendKeys("invalid");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

}



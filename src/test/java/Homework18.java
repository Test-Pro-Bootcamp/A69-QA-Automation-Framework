import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18 {
    @Test
   public void playSong() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://qa.koel.app/";
        driver.navigate().to(url);
        Assert.assertTrue(driver.getPageSource().contains(url));
        Thread.sleep(3000);

        WebElement provideEmail = driver.findElement(By.cssSelector("[type='email']"));
        provideEmail.sendKeys("artemisia.chalkiopoulou@testpro.io");
        WebElement providePassword = driver.findElement(By.cssSelector("[type='password']"));
        providePassword.sendKeys("22002255");
        WebElement login = driver.findElement(By.cssSelector("[type='submit']"));
        login.click();
        Thread.sleep(3000);


        WebElement playNextBtn = driver.findElement(By.cssSelector("i[title='Play next song']"));
        playNextBtn.click();
        Thread.sleep(3000);

        WebElement playBtn = driver.findElement(By.cssSelector("span[title='Play or resume']"));
        playBtn.click();
        Thread.sleep(3000);

        WebElement pauseBtn = driver.findElement(By.cssSelector("span[title='Pause']"));
        Assert.assertTrue(pauseBtn.isDisplayed());
        Thread.sleep(3000);

        driver.quit();
    }
}

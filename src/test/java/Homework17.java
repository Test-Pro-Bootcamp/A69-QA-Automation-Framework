import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 {
    @Test

    public void addSongToPlaylist() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.navigate().to("https://qa.koel.app/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
        WebElement email = driver.findElement(By.cssSelector("[type='email']"));
        email.sendKeys("artemisia.chalkiopoulou@testpro.io");
        WebElement password = driver.findElement(By.cssSelector("[type='password']"));
        password.sendKeys("22002255");
        WebElement login = driver.findElement(By.cssSelector("[type='submit']"));
        login.click();

        WebElement search = driver.findElement(By.cssSelector("[type='search']"));
        search.sendKeys("century");
        WebElement ViewAllButton = driver.findElement(By.cssSelector("button[data-test=/'view-all-songs-btn'/]"));
        ViewAllButton.click();
        WebElement songResult = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/div/div/div[1]/table/tr)"));
        songResult.click();
        WebElement addTo = driver.findElement(By.xpath("//*[@id=/'songResultsWrapper/']/header/div[3]/span/button[2]"));
        addTo.click();
        WebElement favoritesList = driver.findElement(By.xpath("//*[@id=/'songResultsWrapper/']/header/div[3]/div/section[1]/ul/li[4]"));
        favoritesList.click();
        WebElement notification = driver.findElement(By.xpath("//*[@id=/'songResultsWrapper/']/div/div/div[1]/table/tr/td[6]"));
        String actualMessage = notification.getText();
        String playlistName="";
        String expectedMessage = "Added 1 song into " + playlistName;
        Assert.assertEquals(actualMessage, expectedMessage, "Notification message does not match!");

        driver.quit();

    }
}

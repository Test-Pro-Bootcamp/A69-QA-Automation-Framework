import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework20 extends BaseTest {
    private WebDriverWait wait;

    @Test
    public void deletePlaylist() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String expectedMsg = "Deleted playlist \"My Songs 2.\"";

        login("artemisia.chalkiopoulou@testpro.io", "22002255");

        openPlaylist();
        clickDeletePlaylist();

        Assert.assertTrue(isDeleteMessageDisplayed(expectedMsg), "Playlist was not deleted successfully.");
    }
    public void openPlaylist(){
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("li[class='playlist playlist']")));
        playlist.click();
    }

    public void clickDeletePlaylist() {
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[title='Delete this playlist']")));
        deleteButton.click();
    }

    public boolean isDeleteMessageDisplayed(String expectedText) {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='success show']")));
        return message.getText().equals(expectedText);
    }

}
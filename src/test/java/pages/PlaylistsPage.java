package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PlaylistsPage extends BasePage{
//Constructor
    public PlaylistsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

//Locators
    By meta = By.xpath("//span[@class='meta']");
    By deleteButton = By.xpath("//button[@class='del btn-delete-playlist']");
    By okButton = By.xpath("//button[@class='ok']");
    By songListElement = By.cssSelector("section#playlistWrapper td.title");

//Methods

    public boolean checkIfPlaylistEmpty() {
        boolean empty = false;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(meta));

        } catch (Exception e) {
            empty = true;
        }
        return empty;
    }

    public void removePlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
    }

    //Needed ONLY if Playlist is not Empty
    public void confirmDelete() {
       wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
    }

    public void displayAllSongsToConsole() {
        List<WebElement> songList = driver.findElements(songListElement);
        System.out.println("number of songs found:" + countSongs());
        for (WebElement e : songList) {
            System.out.println(e.getText());
        }
    }

    public String getPlaylistDetails() {
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

    public int countSongs() {
        return driver.findElements(songListElement).size();
    }
}

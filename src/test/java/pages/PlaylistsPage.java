package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class PlaylistsPage extends BasePage{

    public PlaylistsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By plusBtn = By.cssSelector("[data-testid='sidebar-create-playlist-btn']");
    By createNewPlaylistBtn = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
    By inputPlaylistName = By.cssSelector(".create input");
    By playlistHeader = By.cssSelector("#playlistWrapper h1");
    By deletePlaylistBtn = By.cssSelector(".btn-delete-playlist");
    By playlists = By.cssSelector("#playlists a");

    public void createPlaylistWithPlusBtn(String playlistName){
        // CREATE PLAYLIST
        // click Plus btn
        wait.until(ExpectedConditions.visibilityOfElementLocated(plusBtn));
        driver.findElement(plusBtn).click();
        // click Create new playlist
        wait.until(ExpectedConditions
                        .elementToBeClickable(createNewPlaylistBtn)).click();
        // Add playlist name
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(inputPlaylistName));
        driver.findElement(inputPlaylistName).click();
        driver.findElement(inputPlaylistName).clear();
        driver.findElement(inputPlaylistName).sendKeys(playlistName);
        // click Enter
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
        wait.until(ExpectedConditions
                .textToBePresentInElement(driver.findElement(playlistHeader), playlistName));
    }

    public void deletePlaylist(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(deletePlaylistBtn)));
        driver.findElement(deletePlaylistBtn).click();
    }

    public List<String> getAllPlaylistNames(){
        List<WebElement> playlistElements = driver.findElements(playlists);
        List<String> playlistNames = new ArrayList<>();

        for (int i = 0; i < playlistElements.size(); i++) {
            String playlistName1 = playlistElements.get(i).getText();
            playlistNames.add(playlistName1);
        }
        return playlistNames;
    }
}

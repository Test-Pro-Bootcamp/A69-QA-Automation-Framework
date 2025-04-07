import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.PlaylistsPage;
import java.util.List;

public class PlaylistTests extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        PlaylistsPage playlistsPage = new PlaylistsPage(driver);
        BasePage basePage = new BasePage(driver);

        String playlistName = generateRandomPlaylistName();
        loginPage.login("planner@testpro.io", "6JooL8gp");
        playlistsPage.createPlaylistWithPlusBtn(playlistName);
        // delete playlist
        Thread.sleep(1000);
        playlistsPage.deletePlaylist();
        Thread.sleep(1000);
        // verify banner
        Assert.assertTrue(basePage.isSuccessBannerDisplayed());
        // refresh page
        driver.navigate().refresh();
        // get playlist names from playlist elements
        List<String> playlistNames = playlistsPage.getAllPlaylistNames();
        // assert playlist was deleted
        Assert.assertFalse(playlistNames.contains(playlistName));
    }
}
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework16 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://qa.koel.app");


            driver.findElement(By.linkText("Registration / Forgot password")).click();

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("register")) {
                System.out.println("Successfully navigated to the registration page!");
            } else {
                System.out.println("Failed to navigate to the registration page.");
            }

        } finally {

            driver.quit();
        }
    }
}

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstHealeniumTest {
    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver delegate = new ChromeDriver();
        SelfHealingDriver driver = SelfHealingDriver.create(delegate);

        driver.get("https://www.google.com");
        Thread.sleep(2000);
        driver.findElement(By.id("APjFqb")).sendKeys("Healenium test\n");

        System.out.println("Test ran successfully. Self-healing driver did its thing ✨");

        driver.quit();
    }
}

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondHealeniumTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver delegate = new ChromeDriver();
        SelfHealingDriver driver = SelfHealingDriver.create(delegate);

        driver.get("https://www.google.com");

        // First run with a stable locator
        driver.findElement(By.name("q")).sendKeys("Healenium test 1\n");
        Thread.sleep(2000); // Give Healenium time to potentially learn

        driver.quit();

        // Simulate a new test run (in a real scenario, this would be a separate execution
        // or a later part of a more complex test)
        WebDriver delegate2 = new ChromeDriver();
        SelfHealingDriver driver2 = SelfHealingDriver.create(delegate2);
        driver2.get("https://www.google.com");

        // Intentionally use a different, potentially unstable locator
        try {
            driver2.findElement(By.xpath("//input[@name='q']")).sendKeys("Healenium test 2\n");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.err.println("Initial locator failed. Healenium might try to heal.");
        }

        Thread.sleep(5000); // Give time for potential healing and reporting

        System.out.println("Second test run completed.");
        driver2.quit();
    }
}
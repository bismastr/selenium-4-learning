import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocators {

    public static WebDriver driver;

    @BeforeAll
    static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    void testRelativeLocator(){
        WebElement loginPanel = driver.findElement(By.id("logInPanelHeading"));
        WebElement credentials = driver.findElement(RelativeLocator.with(By.tagName("span")).above(loginPanel));
        System.out.println(credentials.getText());
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }
}

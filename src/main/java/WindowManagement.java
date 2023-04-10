import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowManagement {

    static WebDriver driver;

    @BeforeAll
    static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }

    @Test
    void testNewWindowTab(){
        WebDriver newWindow = driver.switchTo().newWindow(WindowType.TAB);
        newWindow.get("https://automationexercise.com/product_details/4");

        Set<String> allWindowTabs = driver.getWindowHandles();
        Iterator<String> iterate = allWindowTabs.iterator();
        String mainFristWindow = iterate.next();

        driver.switchTo().window(mainFristWindow);
        driver.manage().window().minimize();
    }
}

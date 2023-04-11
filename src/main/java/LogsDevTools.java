import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.log.Log;

public class LogsDevTools {

    static ChromeDriver driver;
    @BeforeAll
    static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void viewBrowserConsoleLog(){
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Log.enable());

        devTools.addListener(Log.entryAdded(), logEntry -> {
            System.out.println("----------");
            System.out.println("Level: " + logEntry.getLevel());
            System.out.println("Text: " + logEntry.getText());
            System.out.println("Broken URL: " + logEntry.getUrl());
        });

        // Load The AUT
        driver.get("http://the-internet.herokuapp.com/broken_images");
    }
}

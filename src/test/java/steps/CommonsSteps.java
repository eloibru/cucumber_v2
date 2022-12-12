package steps;

import com.google.common.net.MediaType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonsSteps {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        if(scenario.isFailed()){
            final byte[] bytes= ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(bytes, "image/png", scenario.getName());
        }

        webDriver.quit();
        Thread.sleep(1000);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}

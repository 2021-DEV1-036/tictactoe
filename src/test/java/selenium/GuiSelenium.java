package selenium;

import com.googlecode.yatspec.junit.SpecResultListener;
import com.googlecode.yatspec.junit.WithCustomResultListeners;
import com.googlecode.yatspec.state.givenwhenthen.TestState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

public class GuiSelenium extends TestState implements WithCustomResultListeners {

    private static final String START_URL = "http://www.google.com";
    protected WebDriver driver;

    @BeforeEach
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\drive\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(START_URL);
    }

    @AfterEach
    public void quit() throws Exception {
        driver.quit();
    }

    public void takeScreenshoot(String screenshootTitle) throws Exception {
        TakesScreenshot tsDriver = (TakesScreenshot) driver;
        String imageData = tsDriver.getScreenshotAs(OutputType.BASE64);
        this.capturedInputAndOutputs.add(screenshootTitle, new ScreenshootHolder(imageData));
        System.out.println("Captured screen shoot");
    }

    @Override
    public Iterable<SpecResultListener> getResultListeners() throws Exception {
        String testName = this.getClass().getSimpleName();
        return Arrays.asList((SpecResultListener) new HtmlWithScreenshootResultListener(testName));
    }

}

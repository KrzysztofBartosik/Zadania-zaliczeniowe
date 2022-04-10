package Test_Runner_2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestContext2 {
    WebDriver driver_1;
    public TestContext2() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver_1 = new ChromeDriver();
    }
}



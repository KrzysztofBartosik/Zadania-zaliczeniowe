package Test_Runner_2;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static org.junit.Assert.assertEquals;


public class MyStepdefs {
    int i = 0;
    TestContext2 TestContext_1 = new TestContext2();
    private Scenario myScenario;


    @Before
    public void assign_scenario(Scenario scenarioObj)
    {
        myScenario = scenarioObj;
    }


    @Given("User entered his unique email address and password")
    public void userEnteredHisUniqueEmailAddressAndPassword() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        TestContext_1.driver_1.manage().window().maximize();

        TestContext_1.driver_1.get("https://mystore-testlab.coderslab.pl/index.php");
        System.out.println("This Step open the Google and launch the shop");
    }

    @When("User Goes To Sign In")
    public void userGoesToSignInEmailPass() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        TestContext_1.driver_1.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span")).click();
        TestContext_1.driver_1.findElement(By.name("email")).sendKeys("ychu@op.pl");
        TestContext_1.driver_1.findElement(By.name("password")).sendKeys("123321123");
        TestContext_1.driver_1.findElement(By.id("submit-login")).click();
        TestContext_1.driver_1.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/a[2]")).click();
    }

    @When("^Choose clothes and sweater$")
    public void chooseClothesAndSweater() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        // Click clothes
        TestContext_1.driver_1.findElement(By.id("category-3")).click();
        // click product
        TestContext_1.driver_1.findElement(By.xpath("/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article[2]/div/a/img")).click();
        // click quantity

        Thread.sleep(2000);
        TestContext_1.driver_1.findElement(By.id("quantity_wanted")).clear();
        TestContext_1.driver_1.findElement(By.id("quantity_wanted")).sendKeys("5");
        TestContext_1.driver_1.findElement(By.xpath("//*[@id=\"group_1\"]/option[2]")).click();
        // add to chart
        TestContext_1.driver_1.findElement(By.xpath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button")).click();
        Thread.sleep(5000);
        TestContext_1.driver_1.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")).click();
        //assert -20%
        String msgDisct = TestContext_1.driver_1.findElement(By.xpath("/html/body/main/section/div/div/section/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[1]/span[2]")).getText();
        assertEquals("-20%", msgDisct);
        // checkout
        TestContext_1.driver_1.findElement(By.xpath("/html/body/main/section/div/div/section/div/div[2]/div[1]/div[2]/div/a")).click();
        // shipments
        TestContext_1.driver_1.findElement(By.id("checkout-delivery-step")).click();
        Thread.sleep(2000);
        TestContext_1.driver_1.findElement(By.xpath("//*[@id=\"js-delivery\"]/div/div[1]/div[1]/div/span/span")).click();
        TestContext_1.driver_1.findElement(By.xpath("//*[@id=\"js-delivery\"]/button")).click();
        // payment
        TestContext_1.driver_1.findElement(By.xpath("//*[@id=\"payment-option-1\"]")).click();
        TestContext_1.driver_1.findElement(By.xpath("//*[@id=\"conditions_to_approve[terms-and-conditions]\"]")).click();
        // order
        TestContext_1.driver_1.findElement(By.xpath("/html/body/section/div/section/div/div[1]/section[4]/div/form/ul/li/div[1]/span/input")).click();
        TestContext_1.driver_1.findElement(By.xpath("/html/body/section/div/section/div/div[1]/section[4]/div/div[3]/div[1]/button")).click();
    }

    @Then("^Make print screen$")
    public void makePrintScreen() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        TestContext_1.driver_1.get("https://mystore-testlab.coderslab.pl/index.php?controller=order-confirmation&id_cart=93103&id_module=11&id_order=11089&key=ba0b161a6547697e03288850020b82ba");
        final byte[] screenshot = ((TakesScreenshot) TestContext_1.driver_1).getScreenshotAs(OutputType.BYTES);
        myScenario.attach(screenshot, "image/png","zdjęcie");
    }

}

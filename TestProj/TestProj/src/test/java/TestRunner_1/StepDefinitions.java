package TestRunner_1;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    int i = 0;
    TestContext TestContext_1 = new TestContext();

    @Given("User entered his unique email address and password")
    public void user_entered_his_unique_email_address_and_password() throws Throwable {
        TestContext_1.driver_1.manage().window().maximize();
        TestContext_1.driver_1.get("https://mystore-testlab.coderslab.pl/index.php");
        System.out.println("This Step open the Google and launch the shop");
    }


    @When("User Goes To Sign In")
    public void userGoesToSignIn() {
        TestContext_1.driver_1.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span")).click();
        TestContext_1.driver_1.findElement(By.name("email")).sendKeys(generateUniqueEmail());
        TestContext_1.driver_1.findElement(By.name("password")).sendKeys(generatepassword());
        TestContext_1.driver_1.findElement(By.id("submit-login")).click();
        TestContext_1.driver_1.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/a[2]")).click();

    }

    private CharSequence generatepassword() {
        return "123321123";
    }

    private CharSequence generateUniqueEmail() {
        return "ychu" + "@op.pl";
    }


    @When("User enter new address data {string} {string} {string} {string} {string}")
    public void userEnterNewAddressDataAliasAddressCityZipPostalCodePhone(String alias, String address, String city, String zip, String phone) throws PendingException {
        TestContext_1.driver_1.findElement(By.name("alias")).sendKeys(alias);
        TestContext_1.driver_1.findElement(By.name("address1")).sendKeys(address);
        TestContext_1.driver_1.findElement(By.name("postcode")).sendKeys(zip);
        TestContext_1.driver_1.findElement(By.name("city")).sendKeys(city);
        TestContext_1.driver_1.findElement(By.name("phone")).sendKeys(phone);
        TestContext_1.driver_1.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select/option[2]")).click();
        TestContext_1.driver_1.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button")).click();


    }

    @When("Verify page data {string} {string} {string} {string} {string}")
    public void verifyPageDataAliasAddressCityZipPhone(String alias2, String address2, String city2, String zip2, String phone2 ) {
        //wejscie na strone
        TestContext_1.driver_1.get("https://mystore-testlab.coderslab.pl/index.php?controller=addresses");
        // edycja danych konta
        TestContext_1.driver_1.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[1]/article/div[2]/a[1]/span")).click();

        String valMsg = TestContext_1.driver_1.findElement(By.name("alias")).getAttribute("value");
        assertEquals(alias2, valMsg);
        String valMsg2 = TestContext_1.driver_1.findElement(By.name("address1")).getDomAttribute("value");
        assertEquals(address2, valMsg2);
        String valMsg3 = TestContext_1.driver_1.findElement(By.name("city")).getAttribute("value");
        assertEquals(city2, valMsg3);
        String valMsg4 = TestContext_1.driver_1.findElement(By.name("postcode")).getAttribute("value");
        assertEquals(zip2, valMsg4);
        String valMsg5 = TestContext_1.driver_1.findElement(By.name("phone")).getAttribute("value");
        assertEquals(phone2, valMsg5);
    }

    @Then("User saves address settings")
    public void userSavesAddressSettings() {
        TestContext_1.driver_1.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button")).click();
        String valMsg6 = TestContext_1.driver_1.findElement(By.xpath("/html/body/main/section/div/div/section/section/aside/div/article")).getText();
        TestContext_1.driver_1.findElement(By.xpath("/html/body/main/section/div/div/section/section/aside/div/article")).click();

        assertEquals("Address successfully updated!", valMsg6);
    }




}

























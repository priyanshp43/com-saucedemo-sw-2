package testsuite;

/**
 * 1. userSholdLoginSuccessfullyWithValid
 * Credentials()
 * * Enter “standard_user” for the username
 * * Enter “secret_sauce” for the password
 * * Click on the ‘Login’ button
 * * Verify the text “Products”
 *
 * 2. verifyThatSixProductsAreDisplayedOnPage()
 * * Enter “standard_user” for the username
 * * Enter “secret_sauce” for the password
 * * Click on the ‘Login’ button
 * * Verify that six products are displayed on page
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String expectedText = "Products";
        WebElement welcomeTextElement = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        String actualText = welcomeTextElement.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }


}

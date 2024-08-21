package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.LoginPage;

public class LoginTest extends BaseTest {

    LoginPage loginPage;


    @BeforeMethod
    public void setup() {

        loadPropertiesFile();
        initalizeBrowserAndOpenApp("chrome");
        loginPage= new LoginPage(driver);
    }


    @Test
    public void test1LoginWith_Valid_Id_Pass() throws InterruptedException{
        loginPage.enterUsername(prop.getProperty("validEmail"));
        loginPage.enterPassword(prop.getProperty("validPas"));
        loginPage.clickLoginButton();
    }

    @Test
    public void test2LoginWith_inValid_Id_and_validPass () throws InterruptedException{

        loginPage.enterUsername(prop.getProperty("invalidEmail"));
        loginPage.enterPassword(prop.getProperty("validPas"));
        loginPage.clickLoginButton();
        String getMessage=driver.findElement(By.className("toast-message")).getText();
        Assert.assertEquals(getMessage,"Email / Username tidak ditemukan");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Browser closed");
    }
}

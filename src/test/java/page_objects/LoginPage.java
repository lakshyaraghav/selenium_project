package page_objects;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LoginPage extends BaseTest {

//    public static Properties locators = new Properties();

    WebDriver driver;
    By usernameField = By.id(locators.getProperty("username_input_locator"));
    By passwordField = By.xpath("// input[@type=\"password\" and @name=\"password\"]");
    By loginButton = By.xpath("// button[@class=\"button button_danger\" and text()='LOGIN']");

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public void enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}

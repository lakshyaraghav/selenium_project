package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public static Properties prop= new Properties();
    public static Properties locators = new Properties();;


    public void loadPropertiesFile(){


        File propFile= new File(System.getProperty("user.dir")+"/src/test/resources/configfiles/config.properties");
        File locFile= new File(System.getProperty("user.dir")+"/src/test/resources/configfiles/locators.properties");
        try {
            FileInputStream fis= new FileInputStream(propFile);
            FileInputStream loc= new FileInputStream(locFile);
            prop.load(fis);
            locators.load(loc);
        }
        catch (Throwable e){
            e.printStackTrace();
        }

    }

    public WebDriver initalizeBrowserAndOpenApp(String browserName) {

        if(browserName.equals("chrome")){
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equals("edge")) {
            driver= new EdgeDriver();
        } else if (browserName.equals("safari")) {
            driver= new SafariDriver();
        }


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.findElement(By.className("close")).click();
        driver.findElement(By.id("quick-tour-0")).click();
        return driver;
    }


}

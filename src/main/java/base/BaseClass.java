package base;

import constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;
    public static Properties prop;
    public static String path = System.getProperty("user.dir");


    public WebDriver init_driver(String browserName) {

        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println(browserName + ": is not correct or blank");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS.SECONDS);
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT,TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        return driver;
    }

    public static Properties init_properties() {
        prop = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream(path + "\\src\\main\\java\\config\\config.properties");
            prop.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ip.close();
            } catch (IOException ioex) {
                ioex.fillInStackTrace();
            }
            return prop;
        }


    }
}








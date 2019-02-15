package stepDefinitions;

import base.BaseClass;
import constants.Constants;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

import java.util.Properties;

public class LoginPageSteps extends BaseClass {

    public BaseClass baseClass;
    public WebDriver driver;
    public Properties prop;
    public LoginPage loginPage;
    public HomePage homePage;


    @Before("@loginfeature")
    public void setUp() {
        baseClass = new BaseClass();
        prop = BaseClass.init_properties();
        String browser = prop.getProperty("browser");
        driver = baseClass.init_driver(browser);
    }

    @Given("^user Navigates to hubspot website$")
    public void user_Navigates_to_freeCRM_website() {
        driver.get(prop.getProperty("url"));
        loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.verifyLoginPageTitle(), Constants.LOGIN_PAGE_TITLE);

    }

    @And("^user enters username and password$")
    public void user_enters_username_and_password() {
        loginPage.EnterUsernameAndPassword();
    }

    @And("^user clicks on login button$")
    public void user_click_on_login_button() {
        homePage = loginPage.clickLoginButton();
    }

    @Then("^homepage should be displayed$")
    public void homepageShouldBeDisplayed() {
        homePage.verifyhomepage();
        Assert.assertEquals(homePage.getHomePageTitle(), Constants.HOME_PAGE_TITLE);
    }

    @After("@loginfeature")
    public void tearDown() {
        driver.quit();
    }
}



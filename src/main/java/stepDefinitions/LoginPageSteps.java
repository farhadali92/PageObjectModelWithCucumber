package stepDefinitions;

import constants.Constants;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.PropertiesUtils;

public class LoginPageSteps {

    public WebDriver driver;
    public PropertiesUtils propertiesUtils;
    public LoginPage loginPage;
    public HomePage homePage;


    @Before("@loginfeature")
    public void setUp() throws Exception {
        propertiesUtils = PropertiesUtils.getInstance();

        String browser = propertiesUtils.get("browser");
        driver = WebDriverFactory.getWebDriver(browser);
    }

    @Given("^user Navigates to hubspot website$")
    public void user_Navigates_to_freeCRM_website() {
        driver.get(propertiesUtils.get("url"));
        loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.verifyLoginPageTitle(), Constants.LOGIN_PAGE_TITLE);

    }

    @And("^user enters username and password$")
    public void user_enters_username_and_password() {
        loginPage.enterUsernameAndPassword(propertiesUtils.get("username"), propertiesUtils.get("password"));
    }

    @And("^user clicks on login button$")
    public void user_click_on_login_button() {
        homePage = loginPage.clickLoginButton();
    }

    @Then("^homepage should be displayed$")
    public void homepageShouldBeDisplayed() {
        homePage.verifyHomePage();
        Assert.assertEquals(homePage.getHomePageTitle(), Constants.HOME_PAGE_TITLE);
    }

    @After("@loginfeature")
    public void tearDown() {
        driver.quit();
    }
}



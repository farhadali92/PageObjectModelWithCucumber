package stepDefinitions;

import base.BaseClass;
import constants.Constants;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.Map;
import java.util.Properties;

public class LoginPageSteps extends BaseClass {

    public BaseClass baseClass;
    public WebDriver driver;
    public Properties prop;
    public LoginPage loginPage;
    public HomePage homePage;
    public ContactsPage contactsPage;


    @Before
    public void setUp() {
        baseClass = new BaseClass();
        prop = BaseClass.init_properties();
        String browser = prop.getProperty("browser");
        driver = baseClass.init_driver(browser);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("^user Navigates to freeCRM website$")
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
        Assert.assertEquals(homePage.getHomePageTitle(), Constants.HOME_PAGE_TITLE);
    }

    @Then("^user open contacts page$")
    public void userOpenContactsPage() {
        contactsPage = homePage.gotoContactsPage();

    }

    @And("^user clicks on create contact button$")
    public void userClicksOnCreateContactButton() {
        contactsPage.clickCreateContactBtn();
    }

    @Then("^user enters data$")
    public void userEntersData(DataTable contactData) {
        for (Map<String, String> data : contactData.asMaps(String.class, String.class)) {
            contactsPage.createNewContact(data.get("Email"),
                    data.get("Firstname"),
                    data.get("Lastname"),
                    data.get("JobTitle"));
        }
    }
}



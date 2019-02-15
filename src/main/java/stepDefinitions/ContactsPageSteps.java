package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import utils.PropertiesUtils;

import java.util.Map;

public class ContactsPageSteps {

    public WebDriver driver;
    public PropertiesUtils propertiesUtils;
    public LoginPage loginPage;
    public HomePage homePage;
    public ContactsPage contactsPage;

    @Before("@contactsfeature")
    public void setUp() throws Exception {
        propertiesUtils = PropertiesUtils.getInstance();

        String browser = propertiesUtils.get("browser");

        driver = WebDriverFactory.getWebDriver(browser);
        driver.get(propertiesUtils.get("url"));

        loginPage = new LoginPage(driver);
        loginPage.enterUsernameAndPassword(propertiesUtils.get("username"), propertiesUtils.get("password"));
        homePage = loginPage.clickLoginButton();
        homePage.verifyHomePage();
    }

    @Given("^user open contacts page$")
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
            contactsPage.createNewContact
                    (data.get("Email"),
                            data.get("Firstname"),
                            data.get("Lastname"),
                            data.get("JobTitle"));
        }
    }

    @After("@contactsfeature")
    public void tearDown() {
        driver.quit();
    }
}



package stepDefinitions;

import base.BaseClass;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.Map;
import java.util.Properties;

public class ContactsPageSteps extends BaseClass {

    public BaseClass baseClass;
    public WebDriver driver;
    public Properties prop;
    public LoginPage loginPage;
    public HomePage homePage;
    public ContactsPage contactsPage;


    @Before("@contactsfeature")
    public void setUp() {
        baseClass = new BaseClass();
        prop = BaseClass.init_properties();
        String browser = prop.getProperty("browser");
        driver = baseClass.init_driver(browser);
        driver.get(prop.getProperty("url"));
        loginPage = new LoginPage(driver);
        loginPage.EnterUsernameAndPassword();
        homePage = loginPage.clickLoginButton();
        homePage.verifyhomepage();
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



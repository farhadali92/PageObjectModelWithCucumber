package pages;

import base.BaseClass;
import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestUtil;

public class HomePage extends BaseClass {


    @FindBy(xpath = "//h1[text()='Sales Dashboard']")
    WebElement homePageHeader;

    @FindBy(xpath = "//span[text()='Welcome to HubSpot, ']")
    WebElement welcomeText;

    @FindBy(id = "nav-primary-contacts-branch")
    WebElement contactsTab;

    @FindBy(id = "nav-secondary-contacts")
    WebElement contactsLink;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHomePageTitle(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(welcomeText));
        return driver.getTitle();
    }

    public ContactsPage gotoContactsPage(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(contactsTab));
        contactsTab.click();
        TestUtil.waitInSeconds(2);
        contactsLink.click();
        return new ContactsPage(driver);
    }




}

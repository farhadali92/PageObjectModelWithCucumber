package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.TestUtil;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//h1[text()='Sales Dashboard']")
    WebElement homePageHeader;

    @FindBy(xpath = "//span[text()='Welcome to HubSpot, ']")
    WebElement welcomeText;

    @FindBy(id = "nav-primary-contacts-branch")
    WebElement contactsTab;

    @FindBy(id = "nav-secondary-contacts")
    WebElement contactsLink;

    public HomePage(WebDriver driver){
        super(driver);

        PageFactory.initElements(driver, this);
    }

    public void verifyHomePage(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(welcomeText));
    }

    public String getHomePageTitle(){
        return getDriver().getTitle();
    }

    public ContactsPage gotoContactsPage(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(contactsTab));
        contactsTab.click();
        TestUtil.waitInSeconds(2);
        contactsLink.click();
        TestUtil.waitInSeconds(5);
        return new ContactsPage(getDriver());
    }

}
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ContactsPage extends AbstractPage {

    @FindBy(xpath = "//span[text()='Create contact']")
    WebElement createContactBtn;

    @FindBy(xpath = "//li//span[text()='Create contact']")
    WebElement createContactSecondBtn;

    @FindBy(id = "uid-ctrl-1")
    WebElement email;

    @FindBy(id = "uid-ctrl-2")
    WebElement firstName;

    @FindBy(id = "uid-ctrl-3")
    WebElement lastName;

    @FindBy(id = "uid-ctrl-5")
    WebElement jobTitle;


    public ContactsPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    public void clickCreateContactBtn() {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(createContactBtn));
        createContactBtn.click();
    }

    public void createNewContact(String emailVal, String firstname, String lastname, String jobTitle) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(email));
        email.sendKeys(emailVal);

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(firstName));
        firstName.sendKeys(firstname);

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(lastName));
        lastName.sendKeys(lastname);

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(this.jobTitle));
        this.jobTitle.sendKeys(jobTitle);

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(createContactSecondBtn));

        //createContactSecondBtn.click();
    }


}
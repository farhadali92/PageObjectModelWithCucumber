package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath = "//button[@id=\"loginBtn\"]/*[text()='Log in']")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUsernameAndPassword(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public HomePage clickLoginButton() {
        loginButton.click();
        return new HomePage(getDriver());
    }

    public String verifyLoginPageTitle() {
        return getDriver().getTitle();
    }

}
package pages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    @FindBy(id = "username")
    WebElement emailAddress;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//button[@id=\"loginBtn\"]/*[text()='Log in']")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void EnterUsernameAndPassword() {
        emailAddress.sendKeys(prop.getProperty("username"));
        password.sendKeys(prop.getProperty("password"));
    }

    public HomePage clickLoginButton() {
        loginBtn.click();
        return new HomePage(driver);
    }

    public String verifyLoginPageTitle() {
        return driver.getTitle();
    }


}

package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public static final String PAGE_URL = "http://training.skillo-bg.com:4200/users/login";
    private final WebDriver webDriver;
    @FindBy(id ="defaultLoginFormUsername")
    private WebElement usernameTextField;
    @FindBy(xpath = "//form/input[@id='defaultLoginFormPassword']")
    private WebElement passwordTextField;
    @FindBy(xpath = "//*[@class='remember-me']/input[@type='checkbox']")
    private WebElement rememberMeCheckbox;
    @FindBy(id = "sign-in-button")
    private WebElement signInButton;
    public LoginPage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isUrlLoaded(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe(PAGE_URL));
    }
    public void fillInUserName(String username){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(usernameTextField));
        usernameTextField.sendKeys(username);
    }
    public void fillInPassword(String password){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(passwordTextField));
        passwordTextField.sendKeys(password);
    }
    public void checkRememberMe(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(rememberMeCheckbox));
        rememberMeCheckbox.click();
    }
    public boolean isCheckedRememberMe(){
        return rememberMeCheckbox.isSelected();
    }
    public void clickSignIn(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }
    public void navigateTo() {
        this.webDriver.get(PAGE_URL);
    }
    public void completeSingIn(String username, String password){
        fillInUserName(username);
        fillInPassword(password);
        checkRememberMe();
        clickSignIn();
    }

}

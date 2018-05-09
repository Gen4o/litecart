package litecart.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUser extends BasePage {
    /*String email_adress = "tugfbdtc436@gwlr.com";
    String password_key = "Pa$$w0rd";*/

    public AddUser(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"default-menu\"]/ul[2]/li/a/i")
    private WebElement signIn;

    @FindBy(linkText = "New customers click here")
    private WebElement createNewAccount;

    @FindBy(linkText = "Logout")
    private WebElement logout;

    @FindBy(name = "firstname")
    private WebElement firstName;


    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id=\"box-create-account\"]/form/div[6]/div[1]/div/input")
    private WebElement createEmail;

    @FindBy(xpath = "//*[@id=\"box-create-account\"]/form/div[7]/div[1]/div/input")
    private WebElement createPassword;

    @FindBy(xpath = "//*[@id=\"box-create-account\"]/form/div[7]/div[2]/div/input")
    private WebElement confirmPassword;

    @FindBy(name = "create_account")
    private WebElement submitButton;

    @FindBy(css = ".fa.fa-user")
    private WebElement userName;

    @FindBy(css = ".alert")
    private WebElement alertMessage;

    @FindBy(xpath = "//*[@id=\"default-menu\"]/ul[2]/li/ul/li[1]/form/div[1]/div/input")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"default-menu\"]/ul[2]/li/ul/li[1]/form/div[2]/div/input")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"default-menu\"]/ul[2]/li/ul/li[1]/form/div[3]/button")
    private WebElement signInButton;

    /*@FindBy(css = ".alert.alert-danger")
    private WebElement errorAlert;*/

    public AddUser openAddUser() {
        driver.get("http://localhost/litecart/en/");
        return this;
    }

    public AddUser sighIn() {
        wait = new WebDriverWait(driver, 3);
        signIn.click();
        signInButton.click();
        return this;
    }

    public String createUser(String email_adress, String password_key) {
        wait = new WebDriverWait(driver, 3);
        signIn.click();
        signInButton.click();
        createNewAccount.click();
        firstName.sendKeys("Username");
        lastName.sendKeys("UserLastname");
        createEmail.sendKeys(email_adress);
        createPassword.sendKeys(password_key);
        confirmPassword.sendKeys(password_key);
        submitButton.click();
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        return alertMessage.getText();

    }

    public String logOut() {
        wait = new WebDriverWait(driver, 10);
        userName.click();
        logout.click();
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        return alertMessage.getText();
    }

    public String logIn(String email_adress, String password_key) {
        wait = new WebDriverWait(driver, 10);
        signIn.click();
        email.clear();
        email.sendKeys(email_adress);
        password.sendKeys(password_key);
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        return alertMessage.getText();
    }

    /*public String sameUser() {
        wait = new WebDriverWait(driver, 15);
        signIn.click();
        createNewAccount.click();
        firstName.sendKeys("Username");
        lastName.sendKeys("UserLastname");
        //wait.until(ExpectedConditions.visibilityOf(createEmail));
        createEmail.sendKeys(email_adress);
        createPassword.sendKeys(password_key);
        confirmPassword.sendKeys(password_key);
        submitButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorAlert));
        return errorAlert.getText();
    }

    public String invalidLogIn() {
        wait = new WebDriverWait(driver, 10);
        signIn.click();
        email.clear();
        email.sendKeys(email_adress + "erty");
        password.sendKeys(password_key + "fgh");
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorAlert));
        return errorAlert.getText();*/


    }


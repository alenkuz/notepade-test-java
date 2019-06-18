package objects;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotePad {

    private static final By buttonRegisterLogin = By.xpath(".//span[contains(.,'Register/Login')]");
    private static final By fieldRegisterEmail = By.xpath(".//input[@id='registerEmail']");
    private static final By PasswordField = By.xpath(".//*[@placeholder='New Password']");
    private static final By buttonCreateAccount = By.xpath(".//button[contains(text(),'Create Account')]");
    private static final By buttonSettings = By.xpath(".//span[contains(.,'Settings')]");
    private static final By buttonLogout = By.xpath(".//span[contains(.,'Logout')]");


    private WebDriver driver;
    private WebDriverWait wait;

    public NotePad (WebDriver driver)
    {

        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 15);
    }

    @Step
    public NotePad open ()
    {

        driver.get("https://anotepad.com");
        return this;
    }

    @Step
    public NotePad close ()
    {
        driver.quit();
        return this;
    }

    @Step
    public NotePad registerLoginClick ()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonRegisterLogin));
        driver.findElement(buttonRegisterLogin).click();
        return this;
    }

    @Step
    public NotePad enterEmailForLogin (String email)
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(fieldRegisterEmail));
        driver.findElement(fieldRegisterEmail).sendKeys(email);

        return this;
    }

    @Step
    public NotePad fillPasswordField (String password)
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(PasswordField));
        driver.findElement(PasswordField).sendKeys(password);
        return this;

    }

    @Step
    public NotePad clickButtonCreateAccount()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonCreateAccount));
        driver.findElement(buttonCreateAccount).click();
        return this;
    }



    @Step
    public boolean  buttonLogoutIsPresent() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(buttonLogout));
            return true;
        }
        catch (NoSuchElementException ex) {
            return false;
        }

    }

    @Step
    public boolean  buttonSettingsIsPresent() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(buttonSettings));
            return true;
        }
        catch (NoSuchElementException ex) {
            return false;
        }

    }

}

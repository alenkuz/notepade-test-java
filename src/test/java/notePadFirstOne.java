import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class notePadFirstOne {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser (){


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
    }


    @Test

    public void note(){

        driver.get("https://anotepad.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("edit_title")));
        driver.findElement(By.id("edit_title")).sendKeys("My First Note");
        driver.findElement(By.id("btnSaveNote")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".alert"), "You have saved your note as a Guest User. You can come back at anytime to continue editing as long as you don't delete your browser cookies. To access your notes from anywhere and never lose them, please Create a Free Account. Your existing notes will be saved into your account."));
        driver.findElement(By.cssSelector(".delete")).click();


        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        alert.accept();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//ul[@id='savedNotes']"),"No note here."));


    }


    @After
    public  void closeBrowser(){
         driver.quit();
    }
}
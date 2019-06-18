import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import objects.NotePad;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class HW4 {

    WebDriver driver;
    NotePad np;

    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("yyyy.mm.ddhh.mm.ss");
    String strDate = dateFormat.format(date);

    String email = "one" + strDate + "@qwerty.com";
    String password = "qwerty";

    @Before

    public void openBrowser (){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        np = new NotePad(driver);

    }


    /*
     * @DisplayName("GL-75.77 The buttons “Settings”, “Logout” are presented in Header for registered user")
     */
    @Test
    @DisplayName("GL-75.77 The buttons “Settings”, “Logout” is presented in Header for registered user")

    public void RegisterUser(){
        np.open()
                .registerLoginClick()
                .enterEmailForLogin(email)
                .fillPasswordField(password)
                .clickButtonCreateAccount();

        Assert.assertTrue(np.buttonLogoutIsPresent());
        Assert.assertTrue(np.buttonSettingsIsPresent());


    }

    @After
    public  void closeBrowser(){
        driver.close();
    }


}

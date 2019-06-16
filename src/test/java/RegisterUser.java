import io.github.bonigarcia.wdm.WebDriverManager;
//import io.qameta.allure.junit4.DisplayName;
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


public class RegisterUser {

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
     * @DisplayName("GL-75.77 The buttons “Settings”, “Logout” is presented in Header for registered user")
     */
    @Test

    public void RegisterUser(){
        np.open()
                .registerLoginClick()
                .enterEmailForLogin(email)
                .fieldPassword(password)
                .ButtonCreateAccount()
                .buttonLogout()
                .buttonSettings();
        //np.registerLoginClick();
        //np.enterEmailForLogin(email);
        //np.fieldPassword(password);
        //np.ButtonCreateAccount();
        //np.buttonLogout();
        //np.buttonSettings();


    }

    @After
    public  void closeBrowser(){
        np.close();
    }


}

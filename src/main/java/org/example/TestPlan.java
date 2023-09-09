package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPlan {
    static WebDriver driver;
@BeforeSuite
    public static void webDriver(String[] args) {
    System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }
    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get(Utils.URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PracticeForm practiceForm = new PracticeForm(driver);
        practiceForm.fioMail("Иванов", "Иван", "ivanov@example.com");
        practiceForm.genderR();
        practiceForm.userNumberR();
        practiceForm.dateCalendar();
        practiceForm.weekCalendar();
        practiceForm.subject();
        practiceForm.selectSubject();
        practiceForm.picture(Utils.IMAGE);
        practiceForm.theAddress("г Самара, ул Ульяновская, д 52/55, оф 505");
        practiceForm.state();
        practiceForm.city();
        practiceForm.submit();
    }
    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
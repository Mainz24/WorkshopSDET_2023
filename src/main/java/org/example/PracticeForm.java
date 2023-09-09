package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.List;

public class PracticeForm extends PageObject {
    private static final Random random = new Random();
    int mobile = random.nextInt(100000000);
    JavascriptExecutor js = ((JavascriptExecutor) driver);

    public PracticeForm(WebDriver driver) {
        super(driver);
    }
    // ФИО mail
    @Test
    public void fioMail (String firstname, String lastname, String email) {
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        WebElement myEmail = driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        myEmail.sendKeys(email);
    }

    // Gender
    @Test
    public void genderR () {
        List<WebElement> gender = driver.findElements(By.cssSelector("[for^='gender-radio']"));
        if (!gender.isEmpty()) {
            int randomIndex = random.nextInt(gender.size());
            WebElement randomElement = gender.get(randomIndex);
            randomElement.click();
        }
    }

    // Mobile
    @Test
    public void userNumberR (){
        WebElement userNumber = driver.findElement(By.id("userNumber"));
        String phoneNumber = String.format("89%07d", mobile);
        userNumber.sendKeys(phoneNumber);
    }

    //Date of Birth
    @Test
    public void dateCalendar(){
        WebElement date = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        date.click();
    }
    @Test
    public void weekCalendar () {
        List<WebElement> week = driver.findElements(By.cssSelector(".react-datepicker__week [aria-label*='Choose']"));
        if (!week.isEmpty()) {
            int randomIndex = random.nextInt(week.size());
            WebElement randomElement = week.get(randomIndex);
            randomElement.click();
        }
    }

    // Subjects
    @Test
    public void subject (){
        WebElement subjects = driver.findElement(By.cssSelector("#subjectsInput"));
        subjects.click();
        subjects.sendKeys("E");
    }
    @Test
    public void selectSubject(){
        WebElement selectSubjects = driver.findElement(By.id("react-select-2-option-0"));
        selectSubjects.click();
    }

    // Picture
    @Test
    public void picture (String jpg){
        WebElement file = driver.findElement(By.xpath("//input[@type='file']"));
        file.sendKeys(jpg);
    }

    // Current Address
    @Test
    public void theAddress (String a){
        WebElement address = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        address.sendKeys(a);
    }

    // State and City (submit)
    @Test
    public void state() {
        WebElement state = driver.findElement(By.cssSelector("#state .css-yk16xz-control"));
        state.click();
        WebElement stateMenu = driver.findElement(By.cssSelector(".css-yt9ioa-option"));
        stateMenu.click();
    }
    @Test
    public void city(){
        WebElement city = driver.findElement(By.cssSelector("#city .css-yk16xz-control"));
        city.click();
        WebElement cityMenu = driver.findElement(By.cssSelector(".css-yt9ioa-option"));
        cityMenu.click();
    }
    @Test
    public void submit(){
        WebElement submit = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();", submit);
        Assert.assertEquals(driver.findElement(By.id("example-modal-sizes-title-lg")).getText(),"Thanks for submitting the form");
    }
}

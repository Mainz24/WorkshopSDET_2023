package org.example;

import org.openqa.selenium.WebDriver;

public class PageObject {
    protected WebDriver driver;
    public PageObject(WebDriver driver){
        this.driver = driver;
    }
}

package com.testcase.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver webDriver){
        driver = webDriver;
    }
    public ContactPage toMemberAdd() {
        driver.findElement(By.cssSelector("[node-type=addmember]")).click();
        return new ContactPage(driver);
    }

}

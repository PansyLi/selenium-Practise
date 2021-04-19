package com.testcase.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{
    public MainPage(WebDriver webDriver){
        super(webDriver);
    }
    public ContactPage toMemberAdd() {
        driver.findElement(By.cssSelector("[node-type=addmember]")).click();
        return new ContactPage(driver);
    }
    public ContactPage toContactPage() {
        click(By.linkText("通讯录"));
        return new ContactPage(driver);
    }

}

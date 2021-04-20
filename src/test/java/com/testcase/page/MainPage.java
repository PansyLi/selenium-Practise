package com.testcase.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{
    public MainPage(WebDriver webDriver){ super(webDriver); }
    public ContactPage toMemberAdd() {
        driver.findElement(By.cssSelector("[node-type=addmember]")).click();
        return new ContactPage(driver); //add member后 页面会返回到通讯录页面，因此需要返回搭配对应页面去操作
    }
    public ContactPage toContactPage() {
        click(By.id("menu_contacts"));
        return new ContactPage(driver);
    }

}

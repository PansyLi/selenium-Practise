package com.testcase.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;

public class ContactPage extends BasePage{
    WebDriver driver;

    public ContactPage (WebDriver webDriver) {
        super(webDriver);
       // driver = webDriver;
    }
    //HashMap<String,String> data 将多数据直接使用HashMap传进来
    public ContactPage add(String name, String account, String mobile, HashMap<String,String> data){
        driver.findElement(By.name("username")).sendKeys(name);
        driver.findElement(By.name("acctid")).sendKeys(account);
        driver.findElement(By.name("phone")).sendKeys(mobile);
        driver.findElement(By.linkText("save")).click();
        return this;
    }
    public void addFail(){}

    public void delete(){}

    public ContactPage search(String accountId){
        driver.findElement(By.id("")).sendKeys(accountId);
        return this;
    }

    public void importMember(){}

    public void exportMember(){}

    public String getMember(){
        String name = driver.findElement(By.cssSelector(".")).getText();
        return name;
    }
    public void addDepart(){}

}

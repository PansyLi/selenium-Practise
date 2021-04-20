package com.testcase.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;

public class ContactPage extends BasePage{
    public ContactPage(WebDriver webDriver) {
        super(webDriver);
    }

    //HashMap<String,String> data 将多数据直接使用HashMap传进来
    public ContactPage add(String name, String account, String mobile, HashMap<String,String> data){
        driver.findElement(By.id("username")).sendKeys(name);
        driver.findElement(By.id("memberAdd_acctid")).sendKeys(account);
        driver.findElement(By.id("memberAdd_phone")).sendKeys(mobile);
        driver.findElement(By.linkText("Save")).click();
        return this;
    }
    public void addFail(){}

    public void delete(){}

    public ContactPage search(String accountId){
        driver.findElement(By.id("memberSearchInput")).sendKeys(accountId);
        return this;
    }

    public void importMember(){}

    public void exportMember(){}

    public String getMember(){
        String name = driver.findElement(By.cssSelector(".member_display_cover_detail_name")).getText();
        return name;
    }
    public void addDepart(String name, String parent) {
        click(By.linkText("添加"));
        click(By.linkText("添加部门"));
        sendKeys(By.name("name"), name);
        click(By.linkText("选择所属部门"));
//        click(By.linkText("霍格沃兹学院"));
        //避免使用滚动
        driver.findElement(By.tagName("form")).findElement(By.linkText(parent)).click();
        click(By.linkText("确定"));
    }

}

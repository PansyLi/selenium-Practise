package com.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginWorkWechat {
    //https://work.weixin.qq.com/wework_admin/frame
    public static WebDriver driver;

    @BeforeAll
    public static void initData(){
        System.setProperty("webdriver.chrome.driver", "/Users/pan.li/TestEnv/driver/chromedriver");
        driver = new ChromeDriver();
    }
    @Test
    public void login(){
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        driver.findElement(By.id("search-button")).click();
        driver.findElement(By.id("search-term")).sendKeys("学习委员招募");
        driver.findElement(By.xpath("//span[text()='学习委员招募']")).click();
    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}

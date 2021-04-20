package com.testcase.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver;
    Integer retryTimes = 3;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    public void tearDown() {
        driver.quit();
    }
    public boolean click(By by){
        //todo: 突然弹窗阻挡 异常流程 流程调整
        //todo: find找不到 弹窗阻挡 加载延迟
        //todo: click时候报错
        //todo: click不生效
        //todo: click时候被弹窗阻挡
        try{
            driver.findElement(by).click();
        } catch (Exception e){
            e.printStackTrace();
            retryTimes += 1;
            if (retryTimes < 4) {
                //todo: 解决弹框
                this.handleAlert();
                return click(by);
            } else {
                retryTimes = 0;
                return false;

            }
        }
        return true;
    }

    public void clickUntil(By by, By next){
        //todo: 用来解决前几次点击不生效，后面生效的过程
    }

    public void sendKeys(By by, String content){
        driver.findElement(by).sendKeys(content);
    }
    public void handleAlert(){
    //    driver.getPageSource()
        List black = Arrays.asList("","");


    //  List black = Arrays.asList(By.id(""),By.name(""));
    //    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS)
    //    driver.findElement()  隐士等待比较浪费时间


    }
    //也可以使用java注解方式
}

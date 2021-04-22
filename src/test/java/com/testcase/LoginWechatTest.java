package com.testcase;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;


public class LoginWechatTest {
    public static WebDriver webDriver;

    @BeforeAll
    public static void initData(){
        System.setProperty("webdriver.chrome.driver", "/Users/pan.li/TestEnv/driver/chromedriver");
        webDriver = new ChromeDriver();
    }

    @Test
    public void saveCookie() {
        try {
            webDriver.get("https://work.weixin.qq.com/wework_admin/frame");
            Thread.sleep(10000);
            Set<Cookie> cookies = webDriver.manage().getCookies();
            webDriver.navigate().refresh();
            ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory()); //获取cookie，并以yaml格式写入文件中。
            //todo: 使用getResource代替
            //this.getClass().getResource(); 可以读到resource下的文件
            objectMapper.writeValue(new File("cookie.yaml"),cookies);
            cookies.forEach(cookie-> System.out.println(cookie.getName()+":"+cookie.getValue())); //将cookiie打印到console
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginTest() {
        try {
           // webDriver.get("https://work.weixin.qq.com/wework_admin/frame");
            ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory());
            TypeReference<List<HashMap<String, Object>>> typeReference=new TypeReference<List<HashMap<String, Object>>>(){};
            List<HashMap<String, Object>> cookies = objectMapper.readValue(new File("cookie.yaml"), typeReference);
            cookies.forEach(cookie->{
                webDriver.manage().addCookie(new Cookie(cookie.get("name").toString(),cookie.get("value").toString()));
            }); //把取到的cookiie值 以name value形式分别写入新页面。
            webDriver.navigate().refresh();
            webDriver.findElement(By.id("menu_contacts")).click();
            webDriver.findElement(By.id("memberSearchInput")).sendKeys("霍格沃兹");
            webDriver.findElements(By.id("search_party_list")).get(0).click();
            webDriver.findElements(By.cssSelector(".js_add_member")).get(0).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterAll
    public static void tearDown() {
        webDriver.quit();
    }
}

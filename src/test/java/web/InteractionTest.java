package web;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InteractionTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void initData(){
        //Chrome不支持键盘的Action操作
        System.setProperty("webdriver.gecko.driver", "/Users/pan.li/TestEnv/driver/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,5);
    }

    @Test
    //使用鼠标点击
    public void fun(){
        try {
        driver.get("http://sahitest.com/demo/clicks.htm");
        Actions actions = new Actions(driver);
        WebElement dbl = driver.findElement(By.cssSelector("input[value='dbl click me']"));
        WebElement click = driver.findElement(By.cssSelector("input[value='click me']"));
        WebElement right = driver.findElement(By.cssSelector("input[value='right click me']"));
        actions.contextClick(right);
        actions.perform();
        Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    //将鼠标移动到某个元素上
    public void moveTo(){
        driver.get("https://www.baidu.com/");
        Actions actions = new Actions(driver);
        WebElement setEle = driver.findElement(By.id("s-usersetting-top"));
        actions.moveToElement(setEle);
        actions.perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void dragTest(){
        driver.get("http://sahitest.com/demo/dragDropMooTools.htm");
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("dragger"));
        WebElement tag = driver.findElement(By.xpath("//*[@class='item'][2]"));
        actions.dragAndDrop(source, tag);
        actions.perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
    }}

    @Test
    public void keyBoardTest(){
    try {
        driver.get("http://sahitest.com/demo/label.htm");
        Actions action = new Actions(driver);
        WebElement uname1 = driver.findElements(By.xpath("//input[@type='textbox']")).get(0);
        WebElement uname2 = driver.findElements(By.xpath("//input[@type='textbox']")).get(1);
        uname1.sendKeys("ashin");
        action.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
        action.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).perform();
        action.keyDown(Keys.COMMAND).sendKeys("y").keyUp(Keys.COMMAND).perform();
    } catch (Exception e){
        e.printStackTrace();
    }

    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

}

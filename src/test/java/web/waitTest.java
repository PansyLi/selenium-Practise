package web;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void initData(){
        System.setProperty("webdriver.chrome.driver", "/Users/pan.li/TestEnv/driver/chromedriver");
        driver = new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,5);
    }
    //隐式等待，规定时间内查找元素，找到了状态不对不可点击，也会报错

    @Test
    public void login(){
        driver.get("https://ceshiren.com/latest");
        driver.findElement(By.xpath("//*[@class='header-buttons']/button[2]")).click();
        driver.findElement(By.id("login-account-name")).sendKeys("2273230712@qq.com");
        driver.findElement(By.id("login-account-password")).sendKeys("PLesting121!!!");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void webdriverWaitTest(){
        driver.get("https://ceshiren.com/latest");
        driver.findElement(By.xpath("//*[@class='header-buttons']/button[2]")).click();
        //显式等待的两种方式
        //一般情况下混合使用显式和隐式，不用sleep
/*        wait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//*[@class='header-buttons']/button[2]"));
            } //当找不到元素需要进一步处理时，使用此方法
        });*/

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='header-buttons']/button[2]")));
        element.click();
    }

    @Test
    public void timeSleepTest(){
        driver.get("https://ceshiren.com/latest");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@class='header-buttons']/button[2]")).click();
        driver.findElement(By.id("login-account-name")).sendKeys("2273230712@qq.com");
        driver.findElement(By.id("login-account-password")).sendKeys("PLesting121!!!");
        driver.findElement(By.id("login-button")).click();
    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}

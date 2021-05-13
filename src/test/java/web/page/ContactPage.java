package web.page;

import org.openqa.selenium.*;

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
        driver.findElement(By.cssSelector(".js_save:nth-child(0)")).click();
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
    public ContactPage enterEditPage(){
        driver.findElement(By.cssSelector("[data-type='member']:first-child")).click();
        driver.findElement(By.cssSelector(".js_edit")).click();
        return this;

    }
    public String uploadAvatar(String path) throws InterruptedException {
        driver.findElement(By.cssSelector(".js_open_avatarEditor")).click();
        driver.findElement(By.name("uploadImageFile")).sendKeys(path);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='__dialog__avatarEditor__']/div/div[3]/a[1]")).click();
        driver.findElement(By.cssSelector(".js_save:nth-child(2)")).click();
        String message = driver.findElement(By.id("js_tips")).getText();
        return message;
    }
    public String addDepart(String name, String parent) {
        click(By.cssSelector(".js_create_dropdown"));
        click(By.cssSelector(".js_create_party"));
        sendKeys(By.name("name"), name);
        click(By.cssSelector(".js_parent_party_name"));
        click(By.cssSelector(".jstree-themeicon-custom"));
        //避免使用滚动
        driver.findElement(By.tagName("form")).findElement(By.linkText(parent)).click();
        click(By.cssSelector("[d_ck='submit']"));
        String message = driver.findElement(By.cssSelector(".ww_tip success")).getText();
        return message;
    }
    public String deleteDepart(){
        click(By.cssSelector(".jstree-children:last-child"));
//        String departName = driver.findElement(By.cssSelector(".jstree-children:last-child")).getText();
        click(By.cssSelector(".jstree-contextmenu-hover"));
        click(By.linkText("Delete"));
//        JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
//        jsDriver.executeScript("document.querySelector('.jstree-children:last-child').click");
//        jsDriver.executeScript("document.querySelector('.jstree-clicked').click");
        click(By.cssSelector("[d_ck='submit']"));
        String message = driver.findElement(By.cssSelector(".ww_tip success")).getText();
        return message;
    }
}

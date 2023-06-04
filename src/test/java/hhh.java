import Utills.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class hhh {

    @Test
    public void task1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow=origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        Assert.assertEquals(Utils.getTitleJS(driver),"Web Orders Login");

        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        username.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");

        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();

        Assert.assertEquals(Utils.getTitleJS(driver),"Web Orders");
        Thread.sleep(2000);

        WebElement header = driver.findElement(By.tagName("h2"));
        Assert.assertEquals(Utils.getText(header), "List of All Orders");
    }

    @Test
    public void task2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow=origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        username.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");

        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();
        Thread.sleep(2000);

        WebElement allProducts = driver.findElement(By.xpath("//a[.='View all products']"));
        allProducts.click();

        allProducts = driver.findElement(By.xpath("//a[.='View all products']"));
        if(allProducts.isDisplayed() && !allProducts.isSelected()){
            allProducts.click();
        }else {
            System.out.println("False");
        }

        WebElement header = driver.findElement(By.tagName("h2"));
        Assert.assertEquals(Utils.getText(header), "List of Products");

        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("Products"));
    }

    @Test
    public void task3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow=origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        username.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");

        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();
        Thread.sleep(2000);

        WebElement viewOrder = driver.findElement(By.xpath("//li//a[.='View all orders']"));
        System.out.println(Utils.getText(viewOrder));

        WebElement allProducts = driver.findElement(By.xpath("//li//a[.='View all products']"));
        System.out.println(Utils.getText(allProducts));

        WebElement order = driver.findElement(By.xpath("//li//a[.='Order']"));
        System.out.println(Utils.getText(order));
    }

    @Test
    public void task4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow=origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        username.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");

        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();
        Thread.sleep(2000);

        WebElement order = driver.findElement(By.xpath("//a[.='Order']"));
        order.click();


        WebElement select = driver.findElement(By.xpath("//select"));
        Utils.selectBy(select,"ScreenSaver","text");

        WebElement changed = driver.findElement(By.xpath("//input[@onchange='productsChanged()']"));
        changed.clear();
        Thread.sleep(3000);
        changed.sendKeys("5");

        WebElement customerName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerName.sendKeys("CodeFish IT School");

        WebElement street = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        street.sendKeys("2200 E devon");

        WebElement city = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys("Des Plaines");

        WebElement state = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        state.sendKeys("Illinois");

        WebElement zip =driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zip.sendKeys("60018");

        WebElement masterCard = driver.findElement(By.xpath("//input[@value='MasterCard']"));
        masterCard.click();

        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumber.sendKeys("444993876233");

        WebElement cardEx = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        cardEx.sendKeys("03/24");

        WebElement process = driver.findElement(By.xpath("//a[@class='btn_light']"));
        process.click();

        WebElement strong = driver.findElement(By.xpath("//strong"));
        Assert.assertEquals(Utils.getText(strong), "New order has been successfully added.");

        WebElement viewOrder = driver.findElement(By.xpath("//li//a[.='View all orders']"));
        viewOrder.click();


        List<WebElement> allOptions = driver.findElements(By.xpath("//tbody//tr[2]//td"));
        List<String>  expectedOption= Arrays.asList("", "CodeFish IT School","ScreenSaver","5","06/02/2023","2200 E devon","Des Plaines","Illinois","60018","MasterCard","444993876233","03/24", "");


        for(int i=1;i<allOptions.size();i++){
            Assert.assertEquals(allOptions.get(i).getText().trim(),  expectedOption.get(i).trim());
        }
    }
}

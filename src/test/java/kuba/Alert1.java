package kuba;

import Utills.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alert1 {
    @Test
    public void alert() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow=origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");


        WebElement jsAlerts = driver.findElement(By.xpath("//a[.='Javascript Alerts']"));
        jsAlerts.click();

        WebElement lambda = driver.findElement(By.xpath("//button[@class='btn btn-dark my-30 mx-10 hover:bg-lambda-900 hover:border-lambda-900']"));
        lambda.click();

        Alert alert = driver.switchTo().alert();
        String actual = alert.getText().trim();
        String expected = "Alert box!";
        Assert.assertEquals(actual,expected);
        Thread.sleep(2000);
        alert.accept();

        WebElement confirm = driver.findElement(By.xpath("//p[contains(.,'Confirm box:')]//following-sibling::button"));
        confirm.click();
        alert.dismiss();






    }
}

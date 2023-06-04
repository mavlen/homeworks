package KubaHomeWork;

import Utills.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Home1 {
    @Test
    public void home(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow=origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.tumblr.com/");

        WebElement logIn = driver.findElement(By.xpath("//a[.='Log in']"));
        logIn.click();

        WebElement email = driver.findElement(By.xpath("//button[@class='dKGjO']"));
        email.click();

        WebElement sendEmail = driver.findElement(By.xpath("//input[@type='email']"));
        sendEmail.sendKeys("mavlen02t@gmail.com");

        WebElement next = driver.findElement(By.xpath("//span[.='Next']"));
        next.click();

        WebElement setPassword = driver.findElement(By.xpath("//input[@placeholder='Set a password']"));
        setPassword.sendKeys("1244");

        WebElement repeatPassword = driver.findElement(By.xpath("//input[@placeholder='Repeat password']"));
        repeatPassword.sendKeys("1244");

        WebElement nextButton = driver.findElement(By.xpath("//span[.='Next']"));
        nextButton.click();

        WebElement header= driver.findElement(By.xpath("//div[@class='a0A37 hAkP2']"));
        Assert.assertEquals(Utils.getText(header),"The password must be at least 8 characters long.");

    }
}

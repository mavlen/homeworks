package kuba;

import Utills.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Sliders {
    @Test
    public void sliders() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow=origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");

        WebElement sliders = driver.findElement(By.xpath("//a[.='Drag & Drop Sliders']"));
        sliders.click();

       List <WebElement> input = driver.findElements(By.xpath("//input[@type='range']"));
       List<WebElement> output = driver.findElements(By.xpath("//output"));

        for (int i=0;i<input.size();i++){

            while (!output.get(i).getText().equals("99")){
                input.get(i).sendKeys(Keys.ARROW_RIGHT);

            }
        }

    }
    }


package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TinderSwiper {

    @Test
    public void swipeRight(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        
        driver.get(ElementList.tinderLink);
        /*
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // Handle the interruption
            e.printStackTrace();
        }
        */

        

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Create account')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Create account')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='Mend(a)'])[2]")));
        driver.findElement(By.xpath("(//span[@class='Mend(a)'])[2]")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input")));
        driver.findElement(By.xpath("//input")).sendKeys(ElementList.myNumber);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Next']")));
        driver.findElement(By.xpath("//div[text()='Next']")).click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // Handle the interruption
            e.printStackTrace();
        }

        while (true) {
            try{
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='D(b) Expand'])[3]")));
                driver.findElement(By.xpath("(//span[@class='D(b) Expand'])[3]")).click();
            }catch(org.openqa.selenium.TimeoutException e){
                break;
            }
        
        }
        
        driver.quit();
    }

}

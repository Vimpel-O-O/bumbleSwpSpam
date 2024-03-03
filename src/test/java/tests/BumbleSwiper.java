package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BumbleSwiper {

    @Test
    public void swipeRight(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        
        driver.get(ElementList.bumbleLink);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // Handle the interruption
            e.printStackTrace();
        }

        driver.findElement(By.xpath(ElementList.useCellPhone)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone")));
        driver.findElement(By.id("phone")).sendKeys(ElementList.myNumber);

        driver.findElement(By.xpath(ElementList.contBtn)).click();

        while (true) {
            try{
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ElementList.swpRight)));
                driver.findElement(By.xpath(ElementList.swpRight)).click();
            }catch(org.openqa.selenium.TimeoutException e){
                break;
            }
        
        }
        
        driver.quit();
    }

}
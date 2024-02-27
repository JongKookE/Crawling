package com.example.crawling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class SeleniumUtil {
    static private final String FILEPATH = "./upload";
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://comic.naver.com/webtoon");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));


        List<WebElement> weekend = driver.findElements(By.className("WeekdayMainView__daily_all_item--DnTAH"));
        for(WebElement e: weekend){
            WebElement weekendTitle = e.findElement(By.className("WeekdayMainView__heading--tHIYj"));
            System.out.println(weekendTitle.getText());

            List<WebElement> title = e.findElements(By.className("text"));
            List<WebElement> src = e.findElements(By.className("Poster__image--d9XTI"));

            for(WebElement t: title) System.out.println(t.getText());
        }


        driver.quit();
    }
}

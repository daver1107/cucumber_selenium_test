package com.daver1107.logic;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SetUp {
    public WebDriver driver;
    public WebDriverWait wait;

    public SetUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\classes\\RUS_QA\\33.3\\SeleniumTest\\selenium\\chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
    }

}

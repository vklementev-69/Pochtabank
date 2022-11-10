package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final String URL = "https://www.pochtabank.ru/feedback";
//    WebDriver chrome;
//
//    WebElement elFio, elMail, elPhone, elAgreement;
//    WebElement submitBtn;
//    WebDriverWait wait;
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "E:\\Projects\\Autotest\\ChromeDriver\\chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(10));

        System.out.println("Hello world!");
    }
}
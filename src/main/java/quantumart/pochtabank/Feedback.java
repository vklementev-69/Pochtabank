package quantumart.pochtabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Feedback {

    private static final String URL = "https://www.pochtabank.ru/feedback";
    WebDriver chrome;

    WebElement elFio, elMail, elPhone, elAgreement;
    WebElement submitBtn;
    WebDriverWait wait;

    public Feedback() {
        System.setProperty("webdriver.chrome.driver", "E:\\Projects\\Autotest\\ChromeDriver\\chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(chrome, Duration.ofSeconds(10));
    }

    @DataProvider(name = "sms")
    public static Object[][] dbData() {
        return new Object[][]{
                {"Клементьев Вадим Владимирович", "9775676767", "testcase@mail.ru", "Хьюстон, у вас проблемы", true},
                {"Клементьев Вадим Владимирович", "9775676767", "testcase@mail.ru", null, true},
                {"Клементьев Вадим Владимирович", "9775676767", "testcase@mail.ru", null, false},
                {"Клементьев Вадим Владимирович", "9775676767", "testcase@mail.ru", "Хьюстон, у вас проблемы", true},
                {"Клементьев Вадим Владимирович", "9775676767", "testcase@mail.ru", "Хьюстон, у вас проблемы", true},
                {"Клементьев Вадим Владимирович", "9775676767", "testcase@mail.ru", "Хьюстон, у вас проблемы", true},
                {"Клементьев Вадим Владимирович", "9775676767", "testcase@mail.ru", "Хьюстон, у вас проблемы", true},
                {"Клементьев Вадим Владимирович", "9775676767", "testcase@mail.ru", "Хьюстон, у вас проблемы", true},
        };
    }


    @Parameters({"sms"})
    @Test(dataProvider = "sms")
    public void testNoSms(String fio, String phone, String mail, String comment, Boolean checkAgreement) {
        chrome.get(URL);
        try {
            Thread.sleep(2000);
            elFio = chrome.findElement(By.name("fio"));
            elPhone = chrome.findElement(By.name("phone"));
            elMail = chrome.findElement(By.name("email"));
            elAgreement = chrome.findElement(By.name("accept"));
            WebElement elComment = chrome.findElement(By.name("message"));
            submitBtn = chrome.findElement(By.cssSelector("form.style_form__8TDpF submit"));

            elFio.sendKeys(fio);
            elPhone.sendKeys(phone);
            elMail.sendKeys(mail);
            elComment.sendKeys(comment);
            if(!elAgreement.isSelected() && checkAgreement)
                elAgreement.click();

            submitBtn.click();
            //wait.until(ExpectedConditions.jsReturnsValue("return document.querySelector('div.style_modalWrapper__UG622') != null"));

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

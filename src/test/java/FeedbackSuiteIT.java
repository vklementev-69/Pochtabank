import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class FeedbackSuiteIT {
    private static final String URL = "https://www.pochtabank.ru/feedback";

    public void TitleTest() {
        System.setProperty("webdriver.chrome.driver", "E:\\Projects\\Autotest\\ChromeDriver\\chromedriver.exe");
        ChromeDriver chrome = new ChromeDriver();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(10));
        chrome.get(URL);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String title = chrome.getTitle();
        Assert.assertEquals("Правильный заголовок", title, "Обратная связь - Почта Банк");
        chrome.quit();
    }
}

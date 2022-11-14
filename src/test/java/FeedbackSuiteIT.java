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
        System.out.println("Chrome driver Created");
        //WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(10));
        chrome.get(URL);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Feedback page is open.");
        String title = chrome.getTitle();
        System.out.println("Feedback Title - " + title);
        Assert.assertEquals("Правильный заголовок", title, "Обратная связь - Почта Банк");
        chrome.quit();
        System.out.println("Chrome closed");
    }
}

import Pages.MainPage;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

public class ConstructorTest {
    private WebDriver driver;
    private ChromeOptions options = new ChromeOptions();


    @Test
    @Description("Проверка перехода к булкам в конструкторе - Chrome")
    public void bunTestChrome() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.mainPageOpen();
        mainPage.fillingsButtonClick();
        mainPage.fillingsWait();
        mainPage.bunButtonClick();
        mainPage.bunWait();
        assertTrue(mainPage.bunsVisible());
    }
    @Test
    @Description("Проверка перехода к соусам в конструкторе - Chrome")
    public void saucesTestChrome() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.mainPageOpen();
        mainPage.saucesButtonClick();
        mainPage.saucesWait();
        assertTrue(mainPage.saucesVisible());
    }
    @Test
    @Description("Проверка перехода к начинкам в конструкторе - Chrome")
    public void fillingsTestChrome() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.mainPageOpen();
        mainPage.fillingsButtonClick();
        mainPage.fillingsWait();
        assertTrue(mainPage.fillingsVisible());
    }

    @Test
    @Description("Проверка перехода к булкам в конструкторе - Yandex")
    public void bunTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        MainPage mainPage = new MainPage(driver);
        mainPage.mainPageOpen();
        mainPage.fillingsButtonClick();
        mainPage.fillingsWait();
        mainPage.bunButtonClick();
        mainPage.bunWait();
        assertTrue(mainPage.bunsVisible());
    }
    @Test
    @Description("Проверка перехода к соусам в конструкторе - Yandex")
    public void saucesTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        MainPage mainPage = new MainPage(driver);
        mainPage.mainPageOpen();
        mainPage.saucesButtonClick();
        mainPage.saucesWait();
        assertTrue(mainPage.saucesVisible());
    }
    @Test
    @Description("Проверка перехода к начинкам в конструкторе - Yandex")
    public void fillingsTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        MainPage mainPage = new MainPage(driver);
        mainPage.mainPageOpen();
        mainPage.fillingsButtonClick();
        mainPage.fillingsWait();
        assertTrue(mainPage.fillingsVisible());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}

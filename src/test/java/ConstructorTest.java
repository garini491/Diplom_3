import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest {
    private final ChromeOptions options = new ChromeOptions();
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
    }

    @Test
    @Description("Проверка перехода к булкам в конструкторе - Chrome")
    public void bunTestChrome() {
        mainPage.mainPageOpen();
        mainPage.fillingsButtonClick();
        mainPage.fillingsWait();
        mainPage.bunButtonClick();
        mainPage.bunWait();
        assertTrue("Кнопка перехода к булкам не работает: ", mainPage.bunsVisible());
    }

    @Test
    @Description("Проверка перехода к соусам в конструкторе - Chrome")
    public void saucesTestChrome() {
        mainPage.mainPageOpen();
        mainPage.saucesButtonClick();
        mainPage.saucesWait();
        assertTrue("Кнопка перехода к соусам не работает: ", mainPage.saucesVisible());
    }

    @Test
    @Description("Проверка перехода к начинкам в конструкторе - Chrome")
    public void fillingsTestChrome() {
        mainPage.mainPageOpen();
        mainPage.fillingsButtonClick();
        mainPage.fillingsWait();
        assertTrue("Кнопка перехода к начинкам не работает: ", mainPage.fillingsVisible());
    }

    @Test
    @Description("Проверка перехода к булкам в конструкторе - Yandex")
    public void bunTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        mainPage = new MainPage(driver);
        mainPage.mainPageOpen();
        mainPage.fillingsButtonClick();
        mainPage.fillingsWait();
        mainPage.bunButtonClick();
        mainPage.bunWait();
        assertTrue("Кнопка перехода к булкам не работает: ", mainPage.bunsVisible());
    }

    @Test
    @Description("Проверка перехода к соусам в конструкторе - Yandex")
    public void saucesTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        mainPage = new MainPage(driver);
        mainPage.mainPageOpen();
        mainPage.saucesButtonClick();
        mainPage.saucesWait();
        assertTrue("Кнопка перехода к соусам не работает: ", mainPage.saucesVisible());
    }

    @Test
    @Description("Проверка перехода к начинкам в конструкторе - Yandex")
    public void fillingsTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        mainPage = new MainPage(driver);
        mainPage.mainPageOpen();
        mainPage.fillingsButtonClick();
        mainPage.fillingsWait();
        assertTrue("Кнопка перехода к начинкам не работает: ", mainPage.fillingsVisible());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

import api.User;
import api.UserClient;
import api.UserCredentials;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.MainPage;
import pages.PersonalAreaPage;

import static org.junit.Assert.assertTrue;

public class PersonalAreaTest {
    private final User user = new User();
    private final UserClient client = new UserClient();
    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private PersonalAreaPage personalAreaPage;

    @Before
    public void setUp() {
        client.register(user);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        personalAreaPage = new PersonalAreaPage(driver);
    }

    @Test
    @Description("Проверка перехода по клику на лого - Chrome")
    public void logoBurgerClickTestChrome() {
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        personalAreaPage.logoClick();
        assertTrue("Переход по клику на лого не работает: ", mainPage.createOrderButtonVisible());
    }

    @Test
    @Description("Проверка перехода по клику на конструктор - Chrome")
    public void constructorClickTestChrome() {
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        personalAreaPage.constructorClick();
        assertTrue("Переход по клику на лого не работает: ", mainPage.createOrderButtonVisible());
    }

    @Test
    @Description("Проверка перехода в личный кабинет без авторизации - Chrome")
    public void personalAreaTestWithoutAuthChrome() {
        mainPage.mainPageOpen();
        mainPage.personalAreaButtonClick();
        assertTrue(personalAreaPage.loginH2IsVisible());
    }

    @Test
    @Description("Проверка перехода в личный кабинет с авторизацией - Chrome")
    public void personalAreaTestWithAuthChrome() {
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue("Переход по клику на лого не работает: ", personalAreaPage.logoutButtonVisible());
    }

    @Test
    @Description("Проверка перехода по клику на лого - Yandex")
    public void logoBurgerClickTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        personalAreaPage = new PersonalAreaPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        personalAreaPage.logoClick();
        assertTrue("Переход по клику на лого не работает: ", mainPage.createOrderButtonVisible());
    }

    @Test
    @Description("Проверка перехода по клику на конструктор - Yandex")
    public void constructorClickTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        personalAreaPage = new PersonalAreaPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        personalAreaPage.constructorClick();
        assertTrue("Переход по клику на лого не работает: ", mainPage.createOrderButtonVisible());
    }

    @Test
    @Description("Проверка перехода в личный кабинет без авторизации - Yandex")
    public void personalAreaTestWithoutAuth() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        mainPage.mainPageOpen();
        mainPage.personalAreaButtonClick();
        assertTrue("Переход по клику на лого не работает: ", personalAreaPage.loginH2IsVisible());
    }

    @Test
    @Description("Проверка перехода в личный кабинет с авторизацией - Yandex")
    public void personalAreaTestWithAuth() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        personalAreaPage = new PersonalAreaPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue("Переход по клику на лого не работает: ", personalAreaPage.logoutButtonVisible());
    }

    @After
    public void tearDown() {
        driver.quit();
        String bearerForClean = client.login(UserCredentials.from(user)).extract().path("accessToken");
        client.delete(bearerForClean);
    }
}

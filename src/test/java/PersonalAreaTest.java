import Pages.LoginPage;
import Pages.MainPage;
import Pages.PersonalAreaPage;
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

import static org.junit.Assert.assertTrue;

public class PersonalAreaTest {
    WebDriver driver;
    User user = new User();;
    UserClient client = new UserClient();

    @Before
    public void setUp() {
        client.register(user);
    }

    @Test
    @Description("Проверка перехода по клику на лого - Chrome")
    public void logoBurgerClickTestChrome() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        personalAreaPage.logoClick();
        assertTrue(mainPage.createOrderButtonVisible());
    }
    @Test
    @Description("Проверка перехода по клику на конструктор - Chrome")
    public void constructorClickTestChrome() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        personalAreaPage.constructorClick();
        assertTrue(mainPage.createOrderButtonVisible());
    }
    @Test
    @Description("Проверка перехода в личный кабинет без авторизации - Chrome")
    public void personalAreaTestWithoutAuthChrome() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        mainPage.mainPageOpen();
        mainPage.personalAreaButtonClick();
        assertTrue(personalAreaPage.loginH2IsVisible());
    }
    @Test
    @Description("Проверка перехода в личный кабинет с авторизацией - Chrome")
    public void personalAreaTestWithAuthChrome() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue(personalAreaPage.logoutButtonVisible());
    }
    @Test
    @Description("Проверка перехода по клику на лого - Yandex")
    public void logoBurgerClickTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        MainPage mainPage = new MainPage(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        personalAreaPage.logoClick();
        assertTrue(mainPage.createOrderButtonVisible());
    }
    @Test
    @Description("Проверка перехода по клику на конструктор - Yandex")
    public void constructorClickTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        MainPage mainPage = new MainPage(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        personalAreaPage.constructorClick();
        assertTrue(mainPage.createOrderButtonVisible());
    }
    @Test
    @Description("Проверка перехода в личный кабинет без авторизации - Yandex")
    public void personalAreaTestWithoutAuth() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        MainPage mainPage = new MainPage(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        mainPage.mainPageOpen();
        mainPage.personalAreaButtonClick();
        assertTrue(personalAreaPage.loginH2IsVisible());
    }
    @Test
    @Description("Проверка перехода в личный кабинет с авторизацией - Yandex")
    public void personalAreaTestWithAuth() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        MainPage mainPage = new MainPage(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue(personalAreaPage.logoutButtonVisible());
    }


    @After
    public void tearDown() {
        driver.quit();
        String bearerForClean = client.login(UserCredentials.from(user)).extract().path("accessToken");
        client.delete(bearerForClean);
    }
}

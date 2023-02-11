import Pages.*;
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

public class LoginTest {
    private WebDriver driver;
    User user = new User();;
    UserClient client = new UserClient();
    @Before
    public void setUp() {
        client.register(user);
    }

    @Test
    @Description("Авторизация по кнопке 'Войти в аккаунт' в GoogleChrome")
    public void loginOnMainButtonChrome() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue(personalAreaPage.logoutButtonVisible());
    }
    @Test
    @Description("Авторизация через личный кабинет в GoogleChrome")
    public void loginOnPersonalAreaButtonChrome() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        mainPage.mainPageOpen();
        mainPage.personalAreaButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue(personalAreaPage.logoutButtonVisible());
    }
    @Test
    @Description("Авторизация через регистрацию в GoogleChrome")
    public void loginOnRegButtonChrome() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegPage regPage = new RegPage(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.regClick();
        regPage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue(personalAreaPage.logoutButtonVisible());
    }
    @Test
    @Description("Авторизация через востановление пароля в GoogleChrome")
    public void loginOnRestorePasswordButtonChrome() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RestorePage restorePage = new RestorePage(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.scrollToRestoreButton();
        loginPage.restoreButtonClick();
        restorePage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue(personalAreaPage.logoutButtonVisible());
    }
    @Test
    @Description("Авторизация по кнопке 'Войти в аккаунт' в YandexBrowser")
    public void loginOnMainButton() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue(personalAreaPage.logoutButtonVisible());
    }
    @Test
    @Description("Авторизация через личный кабинет в YandexBrowser")
    public void loginOnPersonalAreaButton() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        mainPage.mainPageOpen();
        mainPage.personalAreaButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue(personalAreaPage.logoutButtonVisible());
    }
    @Test
    @Description("Авторизация через регистрацию в YandexBrowser")
    public void loginOnRegButton() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegPage regPage = new RegPage(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.regClick();
        regPage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue(personalAreaPage.logoutButtonVisible());
    }
    @Test
    @Description("Авторизация через востановление пароля в YandexBrowser")
    public void loginOnRestorePasswordButton() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RestorePage restorePage = new RestorePage(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.scrollToRestoreButton();
        loginPage.restoreButtonClick();
        restorePage.loginButtonClick();
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

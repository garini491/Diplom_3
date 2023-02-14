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
import pages.*;

import static org.junit.Assert.assertTrue;

public class LoginTest {
    private final User user = new User();
    private final UserClient client = new UserClient();
    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private RestorePage restorePage;
    private PersonalAreaPage personalAreaPage;
    private RegPage regPage;

    @Before
    public void setUp() {
        client.register(user);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        restorePage = new RestorePage(driver);
        personalAreaPage = new PersonalAreaPage(driver);
        regPage = new RegPage(driver);
    }

    @Test
    @Description("Авторизация по кнопке 'Войти в аккаунт' в GoogleChrome")
    public void loginOnMainButtonChrome() {
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue("Авторизация не прошла: ", personalAreaPage.logoutButtonVisible());
    }

    @Test
    @Description("Авторизация через личный кабинет в GoogleChrome")
    public void loginOnPersonalAreaButtonChrome() {
        mainPage.mainPageOpen();
        mainPage.personalAreaButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue("Авторизация не прошла: ", personalAreaPage.logoutButtonVisible());
    }

    @Test
    @Description("Авторизация через регистрацию в GoogleChrome")
    public void loginOnRegButtonChrome() {
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.regClick();
        regPage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue("Авторизация не прошла: ", personalAreaPage.logoutButtonVisible());
    }

    @Test
    @Description("Авторизация через востановление пароля в GoogleChrome")
    public void loginOnRestorePasswordButtonChrome() {
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.scrollToRestoreButton();
        loginPage.restoreButtonClick();
        restorePage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue("Авторизация не прошла: ", personalAreaPage.logoutButtonVisible());
    }

    @Test
    @Description("Авторизация по кнопке 'Войти в аккаунт' в YandexBrowser")
    public void loginOnMainButton() {
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
        assertTrue("Авторизация не прошла: ", personalAreaPage.logoutButtonVisible());
    }

    @Test
    @Description("Авторизация через личный кабинет в YandexBrowser")
    public void loginOnPersonalAreaButton() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        personalAreaPage = new PersonalAreaPage(driver);
        mainPage.mainPageOpen();
        mainPage.personalAreaButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue("Авторизация не прошла: ", personalAreaPage.logoutButtonVisible());
    }

    @Test
    @Description("Авторизация через регистрацию в YandexBrowser")
    public void loginOnRegButton() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        regPage = new RegPage(driver);
        personalAreaPage = new PersonalAreaPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.regClick();
        regPage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue("Авторизация не прошла: ", personalAreaPage.logoutButtonVisible());
    }

    @Test
    @Description("Авторизация через востановление пароля в YandexBrowser")
    public void loginOnRestorePasswordButton() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        personalAreaPage = new PersonalAreaPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.scrollToRestoreButton();
        loginPage.restoreButtonClick();
        restorePage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue("Авторизация не прошла: ", personalAreaPage.logoutButtonVisible());
    }

    @After
    public void tearDown() {
        driver.quit();
        String bearerForClean = client.login(UserCredentials.from(user)).extract().path("accessToken");
        client.delete(bearerForClean);
    }
}

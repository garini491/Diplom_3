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
import pages.RegPage;

import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    private final User user = new User();
    private final UserClient client = new UserClient();
    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private PersonalAreaPage personalAreaPage;
    private RegPage regPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        personalAreaPage = new PersonalAreaPage(driver);
        regPage = new RegPage(driver);
    }

    @Test
    @Description("Проверка регистрации с невалидным паролем - Chrome")
    public void incorrectPassRegistrationChrome() {
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.regClick();
        regPage.regLogoWait();
        regPage.setIncorrectRegData();
        regPage.regButtonClick();
        assertTrue("Регистрация не прошла: ", regPage.errorVisible());
    }

    @Test
    @Description("Проверка регистрации с валидным паролем - Chrome")
    public void correctPassRegistrationChrome() {
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.regClick();
        regPage.registrationStep();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue("Регистрация не прошла: ", personalAreaPage.logoutButtonVisible());
        String bearerForClean = client.login(UserCredentials.from(user)).extract().path("accessToken");
        client.delete(bearerForClean);
    }

    @Test
    @Description("Проверка регистрации с невалидным паролем - Yandex")
    public void incorrectPassRegistration() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        personalAreaPage = new PersonalAreaPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.regClick();
        regPage.regLogoWait();
        regPage.setIncorrectRegData();
        regPage.regButtonClick();
        assertTrue("Регистрация не прошла: ", regPage.errorVisible());
    }

    @Test
    @Description("Проверка регистрации с валидным паролем - Yandex")
    public void correctPassRegistration() {
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
        regPage.registrationStep();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue("Регистрация не прошла: ", personalAreaPage.logoutButtonVisible());
        String bearerForClean = client.login(UserCredentials.from(user)).extract().path("accessToken");
        client.delete(bearerForClean);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}

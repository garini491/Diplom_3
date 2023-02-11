import Pages.LoginPage;
import Pages.MainPage;
import Pages.PersonalAreaPage;
import Pages.RegPage;
import api.User;
import api.UserClient;
import api.UserCredentials;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    WebDriver driver;
    User user = new User();;
    UserClient client = new UserClient();

    @Test
    @Description("Проверка регистрации с невалидным паролем - Chrome")
    public void incorrectPassRegistrationChrome() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        RegPage regPage = new RegPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.regClick();
        regPage.regLogoWait();
        regPage.setIncorrectRegData();
        regPage.regButtonClick();
        assertTrue(regPage.errorVisible());
    }

    @Test
    @Description("Проверка регистрации с валидным паролем - Chrome")
    public void correctPassRegistrationChrome() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        RegPage regPage = new RegPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.regClick();
        regPage.registrationStep();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue(personalAreaPage.logoutButtonVisible());

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
        MainPage mainPage = new MainPage(driver);
        RegPage regPage = new RegPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.regClick();
        regPage.regLogoWait();
        regPage.setIncorrectRegData();
        regPage.regButtonClick();
        assertTrue(regPage.errorVisible());
    }

    @Test
    @Description("Проверка регистрации с валидным паролем - Yandex")
    public void correctPassRegistration() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver(yandexV100)");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/yandex-browser");
        driver = new ChromeDriver(options);
        MainPage mainPage = new MainPage(driver);
        RegPage regPage = new RegPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.regClick();
        regPage.registrationStep();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        assertTrue(personalAreaPage.logoutButtonVisible());

        String bearerForClean = client.login(UserCredentials.from(user)).extract().path("accessToken");
        client.delete(bearerForClean);
    }
    @After
    public void tearDown() {
        driver.quit();
    }

}

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

public class LogoutTest {
    WebDriver driver;
    User user = new User();;
    UserClient client = new UserClient();
    @Before
    public void setUp() {
        client.register(user);
    }
    @Test
    @Description("Проверка выхода с учетной записи - Chrome")
    public void logoutTestChrome() {
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
        personalAreaPage.logoutButtonClick();
        assertTrue(loginPage.loginButtonVisible());
    }
    @Test
    @Description("Проверка выхода с учетной записи - Yandex")
    public void logoutTest() {
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
        personalAreaPage.logoutButtonClick();
        assertTrue(loginPage.loginButtonVisible());
    }
    @After
    public void tearDown() {
        driver.quit();
        String bearerForClean = client.login(UserCredentials.from(user)).extract().path("accessToken");
        client.delete(bearerForClean);
    }
}

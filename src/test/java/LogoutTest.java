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

public class LogoutTest {
    private final User user = new User();
    private final UserClient client = new UserClient();
    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private PersonalAreaPage personalAreaPage;


    @Before
    public void setUp() {
        client.register(user);
    }

    @Test
    @Description("Проверка выхода с учетной записи - Chrome")
    public void logoutTestChrome() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        personalAreaPage = new PersonalAreaPage(driver);
        mainPage.mainPageOpen();
        mainPage.loginButtonClick();
        loginPage.setLoginData();
        loginPage.loginClick();
        mainPage.personalAreaButtonClick();
        personalAreaPage.logoutButtonClick();
        assertTrue("Выйти из учетной записи не удалось: ", loginPage.loginButtonVisible());
    }

    @Test
    @Description("Проверка выхода с учетной записи - Yandex")
    public void logoutTest() {
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
        personalAreaPage.logoutButtonClick();
        assertTrue("Выйти из учетной записи не удалось: ", loginPage.loginButtonVisible());
    }

    @After
    public void tearDown() {
        driver.quit();
        String bearerForClean = client.login(UserCredentials.from(user)).extract().path("accessToken");
        client.delete(bearerForClean);
    }
}

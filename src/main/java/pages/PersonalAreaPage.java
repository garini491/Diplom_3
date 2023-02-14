package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class PersonalAreaPage {
    private final WebDriver driver;
    // Кнопка "Конструктор"
    private final By constructorButton = By.xpath(".//p[text() = 'Конструктор']");
    // Лого
    private final By logo = By.xpath(".//div[@class = 'AppHeader_header__logo__2D0X2']/a");
    // Кнопка выход
    private final By logoutButton = By.cssSelector(".Account_button__14Yp3");
    private final By loginH2 = By.xpath(".//h2[text() = 'Вход']");

    public PersonalAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод клика на "Конструктор"
    @Step("Нажать на Конструктор")
    public void constructorClick() {
        driver.findElement(constructorButton).click();
    }

    // Метод клика на лого
    @Step("Нажать на Логотип")
    public void logoClick() {
        driver.findElement(logo).click();
    }

    public boolean logoutButtonVisible() {
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        return driver.findElement(logoutButton).isDisplayed();
    }

    @Step("Нажать на кнопку Выйти")
    public void logoutButtonClick() {
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.findElement(logoutButton).click();
    }

    public boolean loginH2IsVisible() {
        return driver.findElement(loginH2).isDisplayed();
    }

}

package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    private final String url = "https://stellarburgers.nomoreparties.site/";
    //    Кнопка войти в акаунт
    private final By loginButton = By.xpath(".//button[text() = 'Войти в аккаунт']");
    //    Кнопка личный кабинет
    private final By personalAreaButton = By.xpath(".//p[text() = 'Личный Кабинет']");
    // Кнопка "Булки"
    private final By bunsButton = By.xpath(".//span[text() = 'Булки']");
    // Кнопка "Соусы"
    private final By saucesButton = By.xpath(".//span[text() = 'Соусы']");
    // Кнопка "Начинки"
    private final By fillingsButton = By.xpath(".//span[text() = 'Начинки']");
    // Заголовок "Соусы"
    private final By sauces = By.xpath(".//h2[text() = 'Соусы']");
    // Заголовок "Начинки"
    private final By fillings = By.xpath(".//h2[text() = 'Начинки']");
    // Заголовок "Булки"
    private final By buns = By.xpath(".//h2[text() = 'Булки']");
    private final By createOrderButton = By.xpath(".//button[text() = 'Оформить заказ']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Открытие страницы
    public void mainPageOpen() {
        driver.get(url);
    }

    // Метод клика на личный кабинет
    @Step("Перейти в личный кабинет")
    public void personalAreaButtonClick() {
        driver.findElement(personalAreaButton).click();
    }

    // Метод клика на кнопку войти
    @Step("Нажать кнопку Войти в аккаунт")
    public void loginButtonClick() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(loginButton)));
        driver.findElement(loginButton).click();
    }

    // Метод клика на кнопку Соусы
    @Step("Нажать на Соусы в конструкторе бургера")
    public void saucesButtonClick() {
        driver.findElement(saucesButton).click();
    }

    // Метод клика на кнопку Булки
    @Step("Нажать на Булки в конструкторе бургера")
    public void bunButtonClick() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(bunsButton)));
        driver.findElement(bunsButton).click();
    }

    // Метод клика на кнопку Начинки
    @Step("Нажать на Начинки в конструкторе бургера")
    public void fillingsButtonClick() {
        driver.findElement(fillingsButton).click();
    }

    // Метод ожидания появления заголовка Булки
    public void bunWait() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(buns)));
    }

    // Метод проверки видимости заголовка "Булки"
    public boolean bunsVisible() {
        return driver.findElement(buns).isDisplayed();
    }

    // Метод ожидания появления заголовка Соусы
    public void saucesWait() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(sauces)));
    }

    // Метод проверки видимости заголовка "Соусы"
    public boolean saucesVisible() {
        return driver.findElement(sauces).isDisplayed();
    }

    // Метод ожидания появления заголовка Начинки
    public void fillingsWait() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(fillings)));
    }

    // Метод проверки видимости заголовка "Начинки"
    public boolean fillingsVisible() {
        return driver.findElement(sauces).isDisplayed();
    }

    // Метод проверки видимости заголовка "Соберите бургер"
    public boolean createOrderButtonVisible() {
        new WebDriverWait(driver, 8)
                .until(ExpectedConditions.visibilityOf(driver.findElement(createOrderButton)));
        return driver.findElement(createOrderButton).isDisplayed();
    }
}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    WebDriver driver;

    private String url = "https://stellarburgers.nomoreparties.site/";
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //    Кнопка войти в акаунт
    private By loginButton = By.xpath(".//button[text() = 'Войти в аккаунт']");
    //    Кнопка личный кабинет
    private By personalAreaButton = By.xpath("//*[@id=\"root\"]/div/header/nav/a");

    // Кнопка "Булки"
    private By bunsButton = By.xpath(".//span[text() = 'Булки']");
    // Кнопка "Соусы"
    private By saucesButton = By.xpath(".//span[text() = 'Соусы']");
    // Кнопка "Начинки"
    private By fillingsButton = By.xpath(".//span[text() = 'Начинки']");
    // Заголовок "Соусы"
    private By sauces = By.xpath(".//h2[text() = 'Соусы']");
    // Заголовок "Начинки"
    private By fillings = By.xpath(".//h2[text() = 'Начинки']");
    // Заголовок "Булки"
    private By buns = By.xpath(".//h2[text() = 'Булки']");

    private By createOrderButton = By.xpath(".//button[text() = 'Оформить заказ']");



    // Открытие страницы
    public void mainPageOpen() {
        driver.get(url);
    }
    // Метод клика на личный кабинет
    public void personalAreaButtonClick() {
        driver.findElement(personalAreaButton).click();
    }
    // Метод клика на кнопку войти
    public void loginButtonClick() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(loginButton)));
        driver.findElement(loginButton).click();
    }
    // Метод клика на кнопку Соусы
    public void saucesButtonClick() {
        driver.findElement(saucesButton).click();
    }
    // Метод клика на кнопку Булки
    public void bunButtonClick() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(bunsButton)));
        driver.findElement(bunsButton).click();
    }
    // Метод клика на кнопку Начинки
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

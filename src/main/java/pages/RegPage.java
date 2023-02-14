package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegPage {
    private static final String name = "firstName";
    private static final String email = "garini491@yandex.ru";
    private static final String password = "12345678";
    private final WebDriver driver;
    // Поле ввода email
    private final By emailField = By.xpath(".//fieldset[2]/div/div/input");
    // Поле ввода пароля
    private final By passwordField = By.xpath(".//fieldset[3]/div/div/input");
    // Поле ввода Имени
    private final By nameField = By.xpath(".//fieldset[1]/div/div/input");
    // Кнопка Регистрации
    private final By registrationButton = By.xpath(".//button[text() = 'Зарегистрироваться']");
    // Заголовок Регистрация
    private final By regLogo = By.xpath(".//h2[text() = 'Регистрация']");
    // Ошибка пароля
    private final By passError = By.xpath(".//p[text() = 'Некорректный пароль']");
    private final By loginButton = By.xpath(".//a[text() = 'Войти']");

    public RegPage(WebDriver driver) {
        this.driver = driver;
    }

    public static String getName() {
        return name;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    @Step("Ввести имя")
    public void setName() {
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Ввести Email")
    public void setEmail() {
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввести валидный пароль")
    public void setCorrectPassword() {
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать кнопку Регистрация")
    public void regButtonClick() {
        driver.findElement(registrationButton);
        driver.findElement(registrationButton).click();
    }

    @Step("Ввести невалидный пароль")
    public void setIncorrectPassword() {
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys("12345");
    }

    @Step("Ввести валидные данные")
    public void setCorrectRegData() {
        setName();
        setEmail();
        setCorrectPassword();
    }

    @Step("Ввести невалидные данные")
    public void setIncorrectRegData() {
        setName();
        setEmail();
        setIncorrectPassword();
    }

    public void regLogoWait() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(regLogo)));
    }

    @Step("Зарегистрироваться")
    public void registrationStep() {
        regLogoWait();
        setCorrectRegData();
        regButtonClick();
    }

    public boolean errorVisible() {
        return driver.findElement(passError).isDisplayed();
    }

    @Step("Нажать на кнопку Войти")
    public void loginButtonClick() {
        driver.findElement(loginButton);
        driver.findElement(loginButton).click();
    }
}

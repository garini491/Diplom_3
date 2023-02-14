package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    // Кнопка регистрации
    private final By regButton = By.xpath(".//a[text() = 'Зарегистрироваться']");
    // Поле ввода email
    private final By emailField = By.xpath(".//input[@name = 'name']");
    // Поле ввода пароля
    private final By passField = By.xpath(".//input[@name = 'Пароль']");
    // Кнопка войти
    private final By loginButton = By.xpath(".//button[text() = 'Войти']");
    // Кнопка восстановить пароль
    private final By restoreButton = By.xpath(".//a[text() = 'Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод ввода email
    @Step("Ввести Email")
    public void setEmail() {
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(RegPage.getEmail());
    }

    public void emailFieldWait() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(emailField));
    }

    // Метод ввода пароля
    @Step("Ввести пароль")
    public void setPassword() {
        driver.findElement(passField).click();
        driver.findElement(passField).sendKeys(RegPage.getPassword());
    }

    public void passwordFieldWait() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(passField));
    }

    // Метод нижатия на кнопку Войти
    @Step("Нажать кнопку Войти")
    public void loginClick() {
        driver.findElement(loginButton).click();
    }

    // Метод нажатия на кнопку Зарегистрироваться
    @Step("Нажать кнопку Зарегистрироваться")
    public void regClick() {
        driver.findElement(regButton).click();
    }

    // Метод нажатия на кнопку Восстановить пароль
    @Step("Нажать кнопку Восстановить пароль")
    public void restoreButtonClick() {
        driver.findElement(restoreButton).click();
    }

    public void scrollToRestoreButton() {
        WebElement element = driver.findElement(restoreButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public boolean loginButtonVisible() {
        return driver.findElement(loginButton).isDisplayed();
    }

    @Step("Авторизоваться")
    public void setLoginData() {
        emailFieldWait();
        setEmail();
        passwordFieldWait();
        setPassword();
    }
}

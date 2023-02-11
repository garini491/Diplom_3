package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Кнопка регистрации
    By regButton = By.className("Auth_link__1fOlj");

    // Поле ввода email
    By emailField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");

    // Поле ввода пароля
    By passField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");

    // Кнопка войти
    By loginButton = By.xpath(".//button[text() = 'Войти']");

    // Кнопка восстановить пароль
    By restoreButton = By.xpath(".//a[text() = 'Восстановить пароль']");


    // Метод ввода email
    public void setEmail() {
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(RegPage.getEmail());
    }

    public void emailFieldWait() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(emailField));
    }

    // Метод ввода пароля
    public void setPassword() {
        driver.findElement(passField).click();
        driver.findElement(passField).sendKeys(RegPage.getPassword());
    }

    public void passwordFieldWait() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(passField));
    }
    // Метод нижатия на кнопку Войти
    public void loginClick() {
        driver.findElement(loginButton).click();
    }

    // Метод нажатия на кнопку Зарегистрироваться
    public void regClick() {
        driver.findElement(regButton).click();
    }

    // Метод нажатия на кнопку Восстановить пароль
    public void restoreButtonClick() {
        driver.findElement(restoreButton).click();
    }

    public void scrollToRestoreButton() {
        WebElement element = driver.findElement(restoreButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public boolean loginButtonVisible() {
        return driver.findElement(loginButton).isDisplayed();
    }

    public void setLoginData() {
        emailFieldWait();
        setEmail();
        passwordFieldWait();
        setPassword();
    }
}

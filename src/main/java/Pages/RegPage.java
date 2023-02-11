package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegPage {
    WebDriver driver;

    private static final String name = "firstName";
    private static final String email = "garini491@yandex.ru";

    private static final String password = "12345678";

    public static String getName() {
        return name;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    public RegPage(WebDriver driver) {
        this.driver = driver;
    }

    // Поле ввода email
    By emailField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");

    // Поле ввода пароля
    By passwordField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input");

    // Поле ввода Имени
    By nameField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");

    // Кнопка Регистрации
    By registrationButton = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");

    // Заголовок Регистрация
    By regLogo = By.xpath(".//h2[text() = 'Регистрация']");

    // Ошибка пароля
    By passError = By.xpath(".//p[text() = 'Некорректный пароль']");

    By loginButton = By.xpath(".//a[text() = 'Войти']");

    public void setName() {
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
    }
    public void setEmail() {
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(email);
    }

    public void setCorrectPassword() {
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void regButtonClick() {
        driver.findElement(registrationButton);
        driver.findElement(registrationButton).click();
    }
    public void setIncorrectPassword() {
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys("12345");
    }

    public void setCorrectRegData() {
        setName();
        setEmail();
        setCorrectPassword();
    }

    public void setIncorrectRegData() {
        setName();
        setEmail();
        setIncorrectPassword();
    }

    public void regLogoWait() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(regLogo)));
    }

    public void registrationStep() {
        regLogoWait();
        setCorrectRegData();
        regButtonClick();
    }

    public boolean errorVisible() {
        return driver.findElement(passError).isDisplayed();
    }

    public void loginButtonClick() {
        driver.findElement(loginButton);
        driver.findElement(loginButton).click();
    }
}

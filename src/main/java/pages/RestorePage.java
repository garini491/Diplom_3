package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePage {
    private final WebDriver driver;
    private final By loginButton = By.xpath(".//a[text() = 'Войти']");

    public RestorePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать кнопку Войти")
    public void loginButtonClick() {
        driver.findElement(loginButton).click();
    }
}

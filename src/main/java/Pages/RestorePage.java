package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePage {
    WebDriver driver;

    public RestorePage(WebDriver driver) {
        this.driver = driver;
    }

    By loginButton = By.xpath(".//a[text() = 'Войти']");

    public void loginButtonClick() {
        driver.findElement(loginButton).click();
    }
}

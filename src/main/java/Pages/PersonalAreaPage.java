package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAreaPage {
    WebDriver driver;

    public PersonalAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginH2 = By.xpath("//*[@id=\"root\"]/div/main/div/h2");

    // Кнопка "Конструктор"
    private By constructorButton = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a");

    // Лого
    private By logo = By.xpath("//*[@id=\"root\"]/div/header/nav/div/a");

    // Метод клика на "Конструктор"
    public void constructorClick() {
        driver.findElement(constructorButton).click();
    }

    // Метод клика на лого
    public void logoClick() {
        driver.findElement(logo).click();
    }

    // Кнопка выход
    private By logoutButton = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button");

    public boolean logoutButtonVisible() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(logoutButton));
        return driver.findElement(logoutButton).isDisplayed();
    }

    public void logoutButtonClick() {
        driver.findElement(logoutButton).click();
    }
    public boolean loginH2IsVisible() {
       return driver.findElement(loginH2).isDisplayed();
    }

}

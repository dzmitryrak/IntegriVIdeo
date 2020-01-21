package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    void click(WebElement element) {
        element.click();
        System.out.println("Ты в меня кликнул");
    }

    public abstract void openPage();
    public abstract void isPageOpened();

    public void waitForVisibilityOFElement(By locator, String message, int timeout) {
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch(TimeoutException ex) {
            throw new TimeoutException (message);
        }
    }
}

package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpPage extends BasePage{
    @FindBy(name = "email")
    WebElement emailInput;
    @FindBy(name = "password")
    WebElement passwordInput;
    @FindBy(id = "signup-form")
    WebElement signUpForm;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://dev.integrivideo.com/signup");
        isPageOpened();
        PageFactory.initElements(driver, SignUpPage.this);
    }

    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("asdasdasdasdasdsdads")));
        } catch(TimeoutException ex) {
            System.out.println("Страница не загрузилась");
            throw new TimeoutException ("Страница не загрузилась");
        }
    }

    public SignUpPage signUp(User user) {
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        signUpForm.submit();
        return this;
    }
}

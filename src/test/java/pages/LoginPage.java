package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(name = "email")
    WebElement emailInput;
    @FindBy(name = "password")
    WebElement passwordInput;
    @FindBy(id = "login-form")
    WebElement loginForm;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://dev.integrivideo.com/login");
        isPageOpened();
        PageFactory.initElements(driver, LoginPage.this);
    }

    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form")));
        } catch(TimeoutException ex) {
            System.out.println("Страница не загрузилась");
            throw new TimeoutException ("Страница не загрузилась");
        }
    }

    public ProjectsPage login(User user) {
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        loginForm.submit();
        ProjectsPage projects = new ProjectsPage(driver);
        projects.isPageOpened();
        return projects;
    }
}

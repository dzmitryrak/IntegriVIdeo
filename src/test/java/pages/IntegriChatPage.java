package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;

public class IntegriChatPage extends BasePage{

    private static final By MESSAGE_TEXT_AREA = By.tagName("textarea");
    private static final By SEND_BUTTON = By.xpath("//button[@title='Send message']");
    private static final By MESSAGE_TEXT = By.cssSelector(".integri-chat-message-text");
    private static final String URL = "https://dev.integrivideo.com/demo/chat/new";
    //Text input
    //Send button
    //Edit button
    //Delete button
    //Copy Code button
    //Invite button
    //Messages locator
    //Settings
    //Profile details locator

    public IntegriChatPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL);
    }

    public void typeMessage(String message) {
        driver.findElement(MESSAGE_TEXT_AREA).sendKeys(message);
    }

    public void sendMessageUsingButton() {
        driver.findElement(SEND_BUTTON).click();
    }


    /**
     *
     * @param message - message to be written
     * @param messageNumber - starts from 1
     */
    public void messageShouldContainText(String message, int messageNumber) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(MESSAGE_TEXT, messageNumber - 1));
        String text = driver.findElements(MESSAGE_TEXT).get(messageNumber - 1).getText();
        assertEquals(message, text, "Message text is not correct");
    }
}

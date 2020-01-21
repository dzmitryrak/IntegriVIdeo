package tests;

import models.User;
import org.testng.annotations.Test;
import pages.SignUpPage;

public class SignUpTest extends BaseTest {

    @Test
    public void signUp() {
        User user = new User("dmitryrak123132@mail.ru", "password");
        new SignUpPage(driver)
                .openPage();
        new SignUpPage(driver).signUp(user);
    }

}

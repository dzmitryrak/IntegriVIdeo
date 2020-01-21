package tests;

import models.Project;
import models.User;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectsPage;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class ProjectTest extends BaseTest{

    @Test
    public void createProject() {
        User user = new User("aqa2@mailinator.com", "password01");
        Project project = new Project("ProjectOne", "Description of Project",
                new ArrayList<String>(Arrays.asList(
                        "tut.by", "https://onliner.by", "www.av.by")));


        loginPage = new LoginPage(driver);
        loginPage.openPage();
        ProjectsPage projectsPage = loginPage.login(user);
        int initialProjectCount =  projectsPage.getProjectCount();
        int finalProjectCount = projectsPage
                .createProject(project)
                .getProjectCount();

        assertEquals(initialProjectCount + 1, finalProjectCount,
                "Количество проектов не увеличилось после создания нового");
    }
}

package WebTesting;

import factory.Header;
import factory.LoginPage;
import factory.PostPage;
import factory.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class ProfileInfoTest extends ProfilePictureTest{
    @Test(dataProvider = "getUser")
        public void testProfileInfo (String username, String password, String userId, File profilePicture){
        WebDriver webDriver = super.getWebDriver();
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);
        String publicInfo = "Student2024";

        loginPage.navigateTo();
        Assert.assertTrue(loginPage.isUrlLoaded(), "Current page is not Login");

        loginPage.completeSingIn(username,password);
        header.clickProfile();
        Assert.assertTrue(profilePage.isUrlLoaded(userId), "Current page is not profile page for " + userId + " user");

        profilePage.clickProfileEdit();
        profilePage.setFieldPublicInfo(publicInfo);
        System.out.println("Stop point");
    }
}

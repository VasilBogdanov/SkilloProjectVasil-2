package WebTesting;

import factory.Header;
import factory.HomePage;
import factory.LoginPage;
import factory.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogoutTest extends TestObject{
    @DataProvider(name="getUser")
    public Object[][] getUsers(){
        return new Object[][]{
                {"Vasil2","Proba71", "5469"},
        };
    }
    @Test(dataProvider = "getUser")
    public void logoutTest(String username, String password, String userId){

        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);

        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded");

        header.clickLogin();
        Assert.assertTrue(loginPage.isUrlLoaded(), "Current page is not Login");

        loginPage.fillInUserName(username);
        loginPage.fillInPassword(password);
        loginPage.checkRememberMe();

        Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember me checkbox is not checked.");

        loginPage.clickSignIn();
        header.clickProfile();
        Assert.assertTrue(profilePage.isUrlLoaded(userId), "Current page in not profile page for " + userId + " user");
        header.clickLogOut();
        Assert.assertTrue(loginPage.isUrlLoaded(), "Logout is not successful");
    }
}

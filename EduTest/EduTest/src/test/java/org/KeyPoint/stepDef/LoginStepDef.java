package org.KeyPoint.stepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.KeyPoint.pages.LoginPage;
import org.KeyPoint.utilities.BrowserUtils;
import org.KeyPoint.utilities.ConfigurationReader;
import org.KeyPoint.utilities.Driver;
import org.junit.Assert;

public class LoginStepDef {
    LoginPage loginPage = new LoginPage();
    @Given("user navigate landing page")
    public void user_navigate_landing_page() {
        String url = ConfigurationReader.get("url");
        //WebDriver driver = Driver.get();
        Driver.get().get(url);
        //System.out.println(Driver.get().getTitle());

    }
    @When("enter valid credentials and click login")
    public void enter_valid_credentials_and_click_login()  {
       // wait(7000);
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");


        loginPage.login(username,password);

    }
    @Then("verify welcome message")
    public void verify_welcome_message() {
        //System.out.println("expectedTitle = " + expectedTitle);
        BrowserUtils.waitFor(2);
        Assert.assertTrue(loginPage.AssertDashboard.getText().contains("Dashboard"));
        //System.out.println(Driver.get().getTitle());
    }

}

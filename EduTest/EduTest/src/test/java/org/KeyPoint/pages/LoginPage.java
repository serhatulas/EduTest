package org.KeyPoint.pages;

import org.KeyPoint.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="email")
    public WebElement userName;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(xpath = "/html/body/div/div/div[1]/div/div[1]/main/div/form/div[4]/button/span[1]")
    public WebElement submit;

    @FindBy(xpath = "//h4[@class='MuiTypography-root MuiTypography-h4']")
    public WebElement AssertDashboard;

    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();
        // verification that we logged
    }
}

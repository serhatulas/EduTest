package org.KeyPoint.pages;

import org.KeyPoint.utilities.BrowserUtils;
import org.KeyPoint.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PendingQuestionsPage extends BasePage {

    @FindBy(xpath="//span[text()=\"Questions\"]")
    public WebElement QuestionsButton;

    @FindBy(xpath="//span[text()=\"Pending Questions\"]")
    public WebElement PendingQuestionsButton;

    @FindBy(xpath="//span[text()=\"All Questions\"]")
    public WebElement AllQuestionsButton;

    @FindBy(xpath="/html/body/div[1]/div/div[1]/div/main/div[2]/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[6]/div/button")
    public WebElement tableEdit;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/main/div[2]/div/form/div[1]/div[1]/div/button[2]")
    public WebElement ApprovedButton;

    @FindBy(xpath="/html/body/div[1]/div/div[1]/div/main/div[2]/div/div[2]/table/tfoot/tr/td/div/div[3]/span[4]/button")
    public WebElement Arrowbutton;

    @FindBy(xpath="/html/body/div[1]/div/div[2]/div/div/div[1]")
    public WebElement ApproveConfirmationText;
    //  "//div[@role='alert']"
    // "//div[@id='5oqmhlkoh']"
    //Question approved

    public static WebElement tableEditFindRowNumberMethod( int RowNumber){
        String xpath ="html/body/div[1]/div/div[1]/div/main/div[2]/div/div[2]/div[2]/div/div/div/table/tbody/tr["+RowNumber+"]/td[6]/div/button";
        return Driver.get().findElement(By.xpath(xpath)) ;
    }
    public static int getNumberOfRowsOnTable() {
        String totalQuestions=Driver.get().findElement(By.xpath("/html/body/div[1]/div/div[1]/div/main/div[2]/div/div[2]/table/tfoot/tr/td/div/div[3]/span[3]")).getText();
        totalQuestions=totalQuestions.substring(6).trim();
        return  Integer.parseInt(totalQuestions);
        //System.out.println("Number"+RowNumber);
    }
}



package org.KeyPoint.stepDef;

import io.cucumber.java.en.*;
import org.KeyPoint.pages.PendingQuestionsPage;
import org.KeyPoint.utilities.BrowserUtils;
import org.KeyPoint.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;

public class PenQuestDef {
    PendingQuestionsPage penQuestPage = new PendingQuestionsPage();

    @Given("expert on pending questions page")
    public void expert_on_pending_questions_page() {
        penQuestPage.QuestionsButton.click();
        penQuestPage.PendingQuestionsButton.click();
        BrowserUtils.waitFor(5);

    }
    @Then("expert edits questions")
    public void expert_edits_questions() {
        int pageNumber = PendingQuestionsPage.getNumberOfRowsOnTable() / 5;
        int lastPageRowNumber = PendingQuestionsPage.getNumberOfRowsOnTable() % 5;
        if (lastPageRowNumber != 0) {
            pageNumber = pageNumber + 1;
        }
        for (int j = 1; j <=pageNumber; j++) {
            int t;
            if (j == pageNumber) {
                t = lastPageRowNumber;
            } else {
                t = 5;
            }
            for (int i = 1; i <= t; i++) {
                BrowserUtils.waitFor(5);
                PendingQuestionsPage.tableEditFindRowNumberMethod(i).click();
                try {
                    BrowserUtils.waitFor(5);
                     // penQuestPage.ApprovedButton.click();
                     // BrowserUtils.waitFor(2);
                     // Assert.assertEquals("Question approved",penQuestPage.ApproveConfirmationText.getText());
                    System.out.println(penQuestPage.ApproveConfirmationText.getText());
                    System.out.println("Page= "+j+" Row= "+i+" ID= "+(Driver.get().getCurrentUrl()).substring((Driver.get().getCurrentUrl().length()-4))+" "+penQuestPage.ApprovedButton.getText());
                   }catch(Exception e){
                    System.out.println("Page= "+j+" Row= "+i+" ID="+ (Driver.get().getCurrentUrl()).substring((Driver.get().getCurrentUrl().length()-4))+" "+" Already Approved");
                }
                if (j ==pageNumber  && t == lastPageRowNumber+1) {
                    break;
                }
                 BrowserUtils.waitFor(5);
                 penQuestPage.PendingQuestionsButton.click();
                 if (j != 1) {
                    int k = 0;
                    do {
                        BrowserUtils.waitFor(5);
                        penQuestPage.Arrowbutton.click();
                        k = k + 1;
                    }
                    while (k != j - 1) ;
                }
            }
                        BrowserUtils.waitFor(5);
                        if (j != pageNumber) {
                            BrowserUtils.waitFor(5);
                            penQuestPage.Arrowbutton.click();
                        }
        }

    }
}



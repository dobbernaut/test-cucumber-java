package health.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;

import java.util.Map;

import health.pages.forms.ClaimSummaryForm;

public class ClaimSummaryStepDefinitions implements En {

    public ClaimSummaryStepDefinitions() {

        Given("I navigate to the claim summary form page", () -> {
            Hooks.driver.get(ClaimSummaryForm.url);
            String title = Hooks.driver.getTitle();
            System.out.println("!!! TITLE !!! - " + title);
        });
        When("^I fill in the claim summary form with the following data:$", (DataTable claimDataTable) -> {
            Map<String, String> claimData = claimDataTable.asMap();

            ClaimSummaryForm claimSummaryFormPage = new ClaimSummaryForm();
            claimSummaryFormPage.claimNumber.sendKeys(claimData.get("claimNumber"));
            claimSummaryFormPage.claimReference.sendKeys(claimData.get("claimReference"));
            claimSummaryFormPage.payeeNumber.sendKeys(claimData.get("payeeNumber"));
            claimSummaryFormPage.agreementNumber.sendKeys(claimData.get("agreementNumber"));
            claimSummaryFormPage.dcnzNumber.sendKeys(claimData.get("dcnzNumber"));
            claimSummaryFormPage.numberOfPatients.sendKeys(claimData.get("numberOfPatients"));
            claimSummaryFormPage.valueOfTreatmentReports.sendKeys(claimData.get("valueOfTreatmentReports"));
            claimSummaryFormPage.submitButton.click();

            Thread.sleep(2000);
        });
    }
}

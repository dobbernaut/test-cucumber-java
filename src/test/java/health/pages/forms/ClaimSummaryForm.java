package health.pages.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import health.stepdefinitions.Hooks;

public class ClaimSummaryForm {
    public static String url = "http://google.co.nz/";

    public WebElement claimNumber = Hooks.driver.findElement(By.id("mat-input-0"));
    public WebElement claimReference = Hooks.driver.findElement(By.id("mat-input-1"));
    public WebElement payeeNumber = Hooks.driver.findElement(By.id("mat-input-2"));
    public WebElement agreementNumber = Hooks.driver.findElement(By.id("mat-input-3"));
    public WebElement dcnzNumber = Hooks.driver.findElement(By.id("mat-input-4"));
    public WebElement numberOfPatients = Hooks.driver.findElement(By.id("mat-input-5"));
    public WebElement valueOfTreatmentReports = Hooks.driver.findElement(By.id("mat-input-6"));
    public WebElement submitButton = Hooks.driver.findElement(By.className("mat-button-wrapper"));
}

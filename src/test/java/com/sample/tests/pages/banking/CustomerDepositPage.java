package com.sample.tests.pages.banking;

import com.sample.framework.kdt.Alias;
import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.tests.framework.ui.controls.Control;
import com.sample.tests.framework.ui.controls.Edit;
import org.openqa.selenium.WebDriver;
@Alias("Deposit")
public class CustomerDepositPage extends CustomerCommonPage {

    public CustomerDepositPage(WebDriver driverValue) {
        super(driverValue);
    }

    @Alias("Deposit Amount")
    @FindBy(locator = "//input[@type='number']")
    public Edit editDepositAmount;

    @Alias("Submit Deposit")
    @FindBy(locator = "//button[text()='Deposit' and @type='submit']")
    public Control buttonSubmitDeposit;

    @Override
    public Page navigate() throws Exception {
        this.buttonDeposit.click();
        return this;
    }
}

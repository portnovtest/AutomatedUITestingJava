package com.sample.tests.pages.banking;

import com.sample.framework.kdt.Alias;
import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.tests.framework.ui.controls.Control;
import org.openqa.selenium.WebDriver;

@Alias("Banking Manager Home")
public class BankManagerCommonPage extends Page {

    public BankManagerCommonPage(WebDriver driver) {
        super(driver);
    }

    @Alias("Add Customer")
    @FindBy(locator = "//button[contains(text(), 'Add Customer')]")
    public Control buttonAddCustomer;

    @Alias("Open Account")
    @FindBy(locator = "//button[contains(text(), 'Open Account')]")
    public Control buttonOpenAccount;

    @Alias("Customers")
    @FindBy(locator = "//button[contains(text(), 'Customers')]")
    public Control buttonCustomers;
}

package com.sample.tests.pages.banking;

import com.sample.framework.kdt.Alias;
import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.tests.framework.ui.controls.Control;
import com.sample.tests.framework.ui.controls.Edit;
import org.openqa.selenium.WebDriver;

@Alias("Add Customer")
public class AddCustomerPage extends BankManagerCommonPage {
    public AddCustomerPage(WebDriver driverValue) {
        super(driverValue);
    }

    @Alias("First Name")
    @FindBy(locator = "//input[@type='text']")
    public Edit editFirstName;

    @Alias("Last Name")
    @FindBy(locator = "xpath=(//input[@type='text'])[2]")
    public Edit editLastName;

    @Alias("Post Code")
    @FindBy(locator = "xpath=(//input[@type='text'])[3]")
    public Edit editPostCode;

    @Alias("Submit")
    @FindBy(locator = "//button[text() ='Add Customer']")
    public Control buttonSubmit;

    public Page navigate() throws Exception {
        return this.buttonAddCustomer.clickAndWaitFor(this.getClass());
    }
}

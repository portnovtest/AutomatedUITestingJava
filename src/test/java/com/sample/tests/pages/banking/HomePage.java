package com.sample.tests.pages.banking;

import com.sample.framework.kdt.Alias;
import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.tests.framework.ui.controls.Control;
import org.openqa.selenium.WebDriver;

@Alias("Banking Home")
public class HomePage extends Page {
    public HomePage(WebDriver driverValue) {
        super(driverValue);
    }

    @Alias("Customer Login")
    @FindBy(locator = "//button[text() = 'Customer Login']")
    public Control buttonCustomerLogin;

    @Alias("Banking Manager Login")
    @FindBy(locator = "//button[text() = 'Bank Manager Login']")
    public Control buttonBankManagerLogin;

    public CustomerCommonPage loginAsCustomer(String name) throws Exception {
        CustomerLoginPage loginPage = this.buttonCustomerLogin.clickAndWaitFor(CustomerLoginPage.class);
        loginPage.selectUser.selectByText(name);
        return loginPage.buttonLogin.clickAndWaitFor(CustomerCommonPage.class);
    }
}

package com.sample.tests.pages.banking;

import com.sample.framework.kdt.Alias;
import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.tests.framework.ui.controls.Control;
import com.sample.tests.framework.ui.controls.SelectList;
import org.openqa.selenium.WebDriver;

@Alias("Customer Login")
public class CustomerLoginPage extends Page {

    public CustomerLoginPage(WebDriver driverValue) {
        super(driverValue);
    }

    @Alias("Select User")
    @FindBy(locator = "userSelect")
    public SelectList selectUser;

    @Alias("Login")
    @FindBy(locator = "//button[text() = 'Login']", excludeFromSearch = true)
    public Control buttonLogin;
}

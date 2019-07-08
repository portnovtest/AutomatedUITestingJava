package com.sample.tests.junit.odt;

import com.sample.framework.Configuration;
import com.sample.framework.Context;
import com.sample.framework.Driver;
import com.sample.framework.odt.ODTTestStep;
import com.sample.framework.ui.PageFactory;
import com.sample.tests.pages.banking.AddCustomerPage;
import com.sample.tests.pages.banking.BankManagerCommonPage;
import com.sample.tests.pages.banking.CustomersPage;
import com.sample.tests.pages.banking.HomePage;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class BankingODTTestSteps {
    public BankingODTTestSteps() {
    }

    public class SetupStep extends ODTTestStep {

        @Override
        public void stepBody() throws Exception {
            Configuration.load();
            Configuration.print();

            System.setProperty("webdriver.gecko.driver", new File("drivers/geckodriver").getAbsolutePath());
            System.setProperty("webdriver.chrome.driver", new File("drivers/chromedriver").getAbsolutePath());

            Assert.assertTrue("Only web platforms are supported by this test", Configuration.platform().isWeb());

            DesiredCapabilities cap = new DesiredCapabilities();
            Driver.add(Configuration.get("browser"), cap);
        }
    }
    public class AfterStep extends ODTTestStep {

        @Override
        public void stepBody() throws Exception {
            Driver.current().quit();
        }
    }
    public class GoToBankManagerStep extends ODTTestStep {

        @Override
        public void stepBody() throws Exception {
            Driver.current().get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
            HomePage home = PageFactory.init(HomePage.class);
            home.buttonBankManagerLogin.clickAndWaitFor(BankManagerCommonPage.class);
        }
    }

    public class GoToBankManagerTabPageStep extends ODTTestStep {
        private Class<? extends BankManagerCommonPage> pageClass;

        public GoToBankManagerTabPageStep(Class<? extends BankManagerCommonPage> pageClass){
            super();
            this.pageClass = pageClass;
        }

        @Override
        public void stepBody() throws Exception {
            PageFactory.init(pageClass).navigate();
        }
    }
    public class AddNewCustomner extends ODTTestStep {
        private String firstName;
        private String lastName;
        private String postCode;

        public AddNewCustomner(String firstName, String lastName, String postCode) {
            super();
            this.firstName = firstName;
            this.lastName = lastName;
            this.postCode = postCode;
        }

        @Override
        public void stepBody() throws Exception {
            Thread.sleep(1000);
            AddCustomerPage addCustomer = PageFactory.init(AddCustomerPage.class);
            addCustomer.editFirstName.setText(firstName);
            addCustomer.editLastName.setText(lastName);
            addCustomer.editPostCode.setText(postCode);
            addCustomer.buttonSubmit.click();
            addCustomer.getDriver().switchTo().alert().accept();
        }
    }
    public class VerifyLastCustomnerData extends ODTTestStep {
        private String firstName;
        private String lastName;
        private String postCode;

        public VerifyLastCustomnerData(String firstName, String lastName, String postCode) {
            super();
            this.firstName = firstName;
            this.lastName = lastName;
            this.postCode = postCode;
        }

        @Override
        public void stepBody() throws Exception {
            CustomersPage customers = PageFactory.init(CustomersPage.class);
            int rows = customers.tableCustomers.getItemsCount();
            Assert.assertEquals(firstName, customers.tableCustomers.getSubItem("First Name", rows - 1).getText());
            Assert.assertEquals(lastName, customers.tableCustomers.getSubItem("Last Name", rows - 1).getText());
            Assert.assertEquals(postCode, customers.tableCustomers.getSubItem("Post Code", rows - 1).getText());
        }
    }
    public class DeleteLastCustomer extends ODTTestStep {

        @Override
        public void stepBody() throws Exception {
            CustomersPage customers = PageFactory.init(CustomersPage.class);
            int rows = customers.tableCustomers.getItemsCount();
            customers.tableCustomers.getSubItem("Delete Customer", rows - 1).click();
        }
    }
    public class VerifyCustomerListNotEmpty extends ODTTestStep {

        @Override
        public void stepBody() throws Exception {
            CustomersPage customers = PageFactory.init(CustomersPage.class);
            Assert.assertTrue(customers.tableCustomers.isNotEmpty());
        }
    }
    public class GetCustomerCount extends ODTTestStep {

        @Override
        public void stepBody() throws Exception {
            GoToBankManagerTabPageStep navigateStep = new GoToBankManagerTabPageStep(CustomersPage.class);
            navigateStep.run();
            CustomersPage customers = PageFactory.init(CustomersPage.class);
            Context.put("Customers Count", customers.tableCustomers.getItemsCount());
        }
    }
    public class VerifyCustomerCountChangedBy extends ODTTestStep {
        private int shift;

        public VerifyCustomerCountChangedBy(int shift) {
            super();
            this.shift = shift;
        }

        @Override
        public void stepBody() throws Exception {
            CustomersPage customers = PageFactory.init(CustomersPage.class);
            Assert.assertEquals((int) Context.get("Customers Count") + this.shift,
                    customers.tableCustomers.getItemsCount());
        }
    }
}

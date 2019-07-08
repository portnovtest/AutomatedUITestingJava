package com.sample.tests.junit.odt;

import com.sample.framework.odt.ODTTestCase;
import com.sample.framework.odt.ODTTestStep;
import com.sample.tests.pages.banking.AddCustomerPage;
import com.sample.tests.pages.banking.CustomersPage;
import org.junit.Test;

public class BankingODTTest extends ODTTestCase {
    public BankingODTTest() {
        this.beforeSteps = new ODTTestStep[] {
                new BankingODTTestSteps().new SetupStep()
        };
        this.afterSteps = new ODTTestStep[] {
                new BankingODTTestSteps().new AfterStep()
        };
        this.steps = new ODTTestStep[] {
                new BankingODTTestSteps().new GoToBankManagerStep(),
                new BankingODTTestSteps().new GoToBankManagerTabPageStep(CustomersPage.class),
                new BankingODTTestSteps().new VerifyCustomerListNotEmpty(),
                new BankingODTTestSteps().new GetCustomerCount(),
                new BankingODTTestSteps().new GoToBankManagerTabPageStep(AddCustomerPage.class),
                new BankingODTTestSteps().new AddNewCustomner("Test","User","WWW99"),
                new BankingODTTestSteps().new GoToBankManagerTabPageStep(CustomersPage.class),
                new BankingODTTestSteps().new VerifyCustomerCountChangedBy(1),
                new BankingODTTestSteps().new VerifyLastCustomnerData("Test","User","WWW99"),
                new BankingODTTestSteps().new GetCustomerCount(),
                new BankingODTTestSteps().new DeleteLastCustomer(),
                new BankingODTTestSteps().new VerifyCustomerCountChangedBy(-1)
        };
    }

    @Test
    public void test() throws Exception {
        this.run();
    }
}

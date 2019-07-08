package com.sample.tests;

import org.junit.Assert;
import org.junit.Test;

public class SearchPageUITest extends TestCommon {

    public SearchPageUITest() {
    }

    @Test
    public void testVerifyUIOnSearchPage(){
        Assert.assertTrue(searchPage.editDestination.exists());
        Assert.assertTrue(searchPage.checkoutDayExpand.exists());
        Assert.assertTrue(searchPage.radioBusiness.exists());
        Assert.assertTrue(searchPage.radioLeisure.exists());
        Assert.assertTrue(searchPage.selectAdultsNumber.exists());
        Assert.assertTrue(searchPage.buttonSubmit.exists());
    }
}

package com.sample.tests.pages;

import com.sample.framework.Platform;
import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.framework.Configuration;
import com.sample.tests.controls.LocationLookupEdit;
import com.sample.tests.framework.ui.controls.Control;
import com.sample.tests.framework.ui.controls.Edit;
import com.sample.tests.framework.ui.controls.SelectList;
import org.openqa.selenium.WebDriver;

public class SearchPage extends Page {

    @FindBy(locator = "ss")
    @FindBy(locator = "search_searchInput", platform = Platform.ANDROID_NATIVE)
    public LocationLookupEdit editDestination;
    @FindBy(locator = "css=li.c-autocomplete__item")
    @FindBy(locator = "checkincell", platform = Platform.ANDROID_NATIVE)
    public Control checkoutDayExpand;
    @FindBy(locator = "(//android.widget.TextView[contains(@resource-id,'calendar_tv') and @enabled='true'])",
    platform = Platform.ANDROID_NATIVE)
    @FindBy(locator = "xpath=(//table[@class='bui-calendar__dates']//td[contains(@class, 'bui-calendar__date--today')])")
    public Control checkoutDayToday;
    @FindBy(locator = "sb_travel_purpose_checkbox")
    @FindBy(locator = "business_purpose_leisure", platform = Platform.ANDROID_NATIVE)
    public Control radioLeisure;
    @FindBy(locator = "sb_travel_purpose_checkbox")
    @FindBy(locator = "business_purpose_business", platform = Platform.ANDROID_NATIVE)
    public Control radioBusiness;
    @FindBy(locator = "xpath=(//input[@name='nflt'])[2]")
    public Control radioHotels;
    @FindBy(locator = "css=button.bui-button[data-bui-ref='input-stepper-subtract-button']")
    public Control adultSelector;
    @FindBy(locator = "group_adults")
    @FindBy(locator = "adult_content", platform = Platform.ANDROID_NATIVE)
    public SelectList selectAdultsNumber;
    @FindBy(locator = "xpath=(//button[@type='submit'])")
    @FindBy(locator = "search_search", platform = Platform.ANDROID_NATIVE)
    public Control buttonSubmit;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public Page navigate(){
        if (Configuration.platform().isWeb()){
            String baseUrl = Configuration.get("url");
            this.getDriver().get(baseUrl);
        }
        return this;
    }
    public void checkInToday(){
        checkoutDayExpand.click();
        checkoutDayToday.click();
    }
    public void selectTravelFor(boolean isLeisure){
        if (isLeisure){
            radioLeisure.click();
        } else {
            radioBusiness.click();
        }
    }
}

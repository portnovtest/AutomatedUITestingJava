package com.sample.tests.pages.android;

import com.sample.framework.Platform;
import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.tests.framework.ui.controls.Control;
import com.sample.tests.framework.ui.controls.Edit;
import org.openqa.selenium.WebDriver;

public class LocationSearchPage extends Page {
    public LocationSearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(locator = "disam_search", platform = Platform.ANDROID_NATIVE)
    public Edit editSearch;
    @FindBy(locator = "xpath=(//li[contains(@class,'c-autocomplete__item sb-autocomplete__item sb-autocomplete__item-with_photo sb-autocomplete__item--district sb-autocomplete__item__item--elipsis')])[1]",
    platform = Platform.ANDROID_NATIVE)
    public Control itemTopMostResult;
}

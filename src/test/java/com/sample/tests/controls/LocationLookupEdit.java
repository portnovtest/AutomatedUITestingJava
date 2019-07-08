package com.sample.tests.controls;

import com.sample.framework.Configuration;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.PageFactory;
import com.sample.tests.framework.ui.controls.Control;
import com.sample.tests.framework.ui.controls.Edit;
import com.sample.tests.pages.android.LocationSearchPage;
import org.openqa.selenium.By;

public class LocationLookupEdit extends Edit {
    public LocationLookupEdit(Page parentValue, By locatorValue) {
        super(parentValue, locatorValue);
    }

    @Override
    public void setText(String value) throws Exception {
        this.click();
        if (Configuration.platform().isWeb()){
            this.getElement().clear();
            this.getElement().sendKeys(value);
            Control lookupItem = new Control(this.getParent(), By.xpath("(//li[contains(@class,'c-autocomplete__item sb-autocomplete__item sb-autocomplete__item-with_photo sb-autocomplete__item--district sb-autocomplete__item__item--elipsis')])[1]"));
            lookupItem.click();
        } else {
            LocationSearchPage search = PageFactory.init(LocationSearchPage.class);
            search.editSearch.setText(value);
            search.itemTopMostResult.click();
        }

    }
}

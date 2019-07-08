package com.sample.tests;

import com.sample.framework.Configuration;
import com.sample.framework.Driver;
import com.sample.framework.ui.PageFactory;
import com.sample.tests.pages.SearchPage;
import com.sample.tests.pages.SearchResultsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BookingSearchTest extends TestCommon {
    private WebDriver driver;
    private String destination;
    private boolean isLeisure;
    private int numberOfAdults;



    public BookingSearchTest(String destination, boolean isLeisure, int numberOfAdults) {
        super();
        this.destination = destination;
        this.isLeisure = isLeisure;
        this.numberOfAdults = numberOfAdults;
    }
    @Parameters
    public static Collection<Object[]> getParameters(){
        return Arrays.asList(
                new Object[][]{
                        {"London", true, 2 },
                        {"Manchester", false, 1},
                });
    }
//    @DataProvider(name = "source")
//    public static Object[][] getParameters(){
//        return new Object[][]{
//                        {"London", true, 2 },
//                        {"Manchester", false, 1},
//    };
//        }



    @Test
    public void testValidSearch() throws Exception {
        searchPage.editDestination.setText(destination);
        searchPage.checkoutDayToday.click();
        //Thread.sleep(2000);
        //searchPage.checkoutDayExpand.click();
        //searchPage.checkoutDayToday.click();
        searchPage.selectTravelFor(isLeisure);
        if (Configuration.platform().isWeb()){
            searchPage.radioHotels.click();
        }
        //searchPage.selectAdultsNumber.selectByText("" + numberOfAdults);
        searchResultsPage = searchPage.buttonSubmit.clickAndWaitFor(SearchResultsPage.class);
        //searchResultsPage.editDestination.click();
        searchResultsPage.isTextPresent(destination);
        searchResultsPage.captureScreenShot("./build/image01.png");

//        driver.findElement(By.id("ss")).clear();
//        driver.findElement(By.id("ss")).sendKeys(this.destination);
//        Thread.sleep(2000);
//        driver.findElement(By.cssSelector("li.c-autocomplete__item")).click();
//        driver.findElement(By.xpath("//table[@class='bui-calendar__dates']//td[contains(@class, 'bui-calendar__date--today')]")).click();
//        driver.findElement(By.cssSelector(".xp__guests__count")).click();
//        if (this.numberOfAdults == 1){
//            driver.findElement(By.cssSelector("button.bui-button[data-bui-ref=\"input-stepper-subtract-button\"]")).click();
//        }
        //driver.findElement(By.cssSelector("button.bui-button[data-bui-ref=\"input-stepper-subtract-button\"]")).click();
        //driver.findElement(By.cssSelector(".xp__guests__count")).click();
//        if (this.isLeisure) {
//            driver.findElement(By.id("sb_travel_purpose_checkbox")).clear();
//        } else {
//            driver.findElement(By.id("sb_travel_purpose_checkbox")).click();
//        }
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        driver.findElement(By.cssSelector("div.sb-date-field__display")).click();
//        driver.findElement(By.id("ss")).click();
    }


}

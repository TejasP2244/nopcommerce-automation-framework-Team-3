package com.nopc.automation.tests.search;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopc.automation.pages.*;
import com.nopc.automation.tests.base.BaseTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchTests extends BaseTest {
    @Test(description="TC14 – Verify search returns results for valid product")
    public void tc14_valid_search(){
        HomePage home=new HomePage();
        SearchPage sp=home.search("Build your own computer");
        Assert.assertTrue(sp.hasResults());
    }
    @Test(description="TC15 – Verify 'No result' message for invalid product")
    public void tc15_invalid_search(){
        HomePage home=new HomePage();
        SearchPage sp=home.search("zzzzzzinvalid");
        Assert.assertTrue(sp.hasNoResults());
    }
    @Test(description="TC16 – Verify product sorting by Price: Low to High")
    public void tc16_sort_low_to_high() throws InterruptedException {
        HomePage home=new HomePage();
        home.navToDesktops();
        SearchPage sp=new SearchPage();
        sp.sortBy("Price: Low to High");
        sp.waitForPriceSortingLowToHigh();
        List<Double> actualPrices=sp.getAllProductPrices();
        List<Double> expPrices=new ArrayList<>(actualPrices);
        Collections.sort(expPrices);
        Assert.assertEquals(actualPrices,expPrices);
    }
    @Test(description="TC17 – Verify product sorting by Price: High to Low")
    public void tc17_sort_high_to_low(){
        HomePage home=new HomePage();
        home.navToDesktops();
        SearchPage sp=new SearchPage();
        sp.sortBy("Price: High to Low");
        sp.waitForPriceSortingHighToLow();
        List<Double> actualPrices=sp.getAllProductPrices();
        List<Double> expPrices=new ArrayList<>(actualPrices);
        expPrices.sort(Collections.reverseOrder());
        Assert.assertEquals(actualPrices,expPrices);
    }
    @Test(description="TC18 – Verify search with partial product name")
    public void tc18_partial_search(){
        HomePage home=new HomePage();
        SearchPage sp=home.search("Build");
        Assert.assertTrue(sp.hasResults());
    }
}

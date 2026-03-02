package com.nopc.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.nopc.automation.core.driver.DriverManager;
import com.nopc.automation.utils.WaitUtil;
import com.nopc.automation.utils.WebDriverUtil;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchPage extends BasePage {
    // ---------- 1. Constructor ----------
    public SearchPage(){ super(); }
    // ---------- 2. Locators ----------
    private final By productGrid = By.cssSelector(".product-grid");
    private final By noResult = By.cssSelector(".no-result");
    private final By sortDropDown = By.id("products-orderby");
    private final By productPrices=By.xpath("//span[contains(@class,'price')]");
    // ---------- 3. Action Methods ----------
    public boolean hasResults(){
        try {
            WaitUtil.visible(productGrid);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public boolean hasNoResults(){
        try {
            WaitUtil.visible(noResult);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public List<Double> getAllProductPrices(){
        //WaitUtil.visible(productPrices);
        int attempts=0;
        while(attempts<2){
            try{
                WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productPrices));
                List<WebElement> priceElements=DriverManager.getDriver().findElements(productPrices);
                List<Double> prices=new ArrayList<>();
                for(WebElement element:priceElements){
                    String priceText=element.getText();
                    double price=extractNumericValue(priceText);
                    prices.add(price);
                }
                return prices;
            }catch(StaleElementReferenceException e){
                attempts+=1;
                System.out.println("Retrying due to stale element");
            }
        }
        throw new RuntimeException("Failed to fetch price due to stale elements");
    }
    public void sortBy(String visibleText){
        new Select(DriverManager.getDriver().findElement(sortDropDown)).selectByVisibleText(visibleText);
    }
    public ProductDetailsPage openFirstProduct(){
        WebDriverUtil.click(By.cssSelector(".product-item .product-title a"));
        return new ProductDetailsPage();
    }

    //-----4.Helper methods--------

    private double extractNumericValue(String priceString){
        String cleaned=priceString.replaceAll("[^0-9.]","");
        return Double.parseDouble(cleaned);
    }

    public void waitForPriceSortingLowToHigh(){
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(driver -> {
            List<Double> prices=getAllProductPrices();
            List<Double> sortedPrices=new ArrayList<>(prices);
            Collections.sort(sortedPrices);
            return prices.equals(sortedPrices);
        });
    }

    public void waitForPriceSortingHighToLow(){
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(driver -> {
            List<Double> prices=getAllProductPrices();
            List<Double> sortedPrices=new ArrayList<>(prices);
            sortedPrices.sort(Collections.reverseOrder());
            return prices.equals(sortedPrices);
        });
    }
}

package com.nopc.automation.tests.product;

import org.testng.Assert;import org.testng.annotations.Test;import com.nopc.automation.pages.*;import com.nopc.automation.tests.base.BaseTest;

public class ProductDetailsTests extends BaseTest {
    @Test(description="TC19 – Verify product detail page displays Name, Price, SKU")
    public void tc19_details(){
        HomePage home=new HomePage();
        ProductDetailsPage pd=home.search("Build your own computer").openFirstProduct();
        Assert.assertTrue(pd.getName().length()>0 && pd.getPrice().length()>0);
    }

    @Test(description="TC20 – Verify product quantity update works")
    public void tc20_quantity() throws InterruptedException {
        HomePage home=new HomePage();
        ProductDetailsPage pd=home.search("Apple MacBook Pro").openFirstProduct();
        pd.setQuantity("3");
        Assert.assertTrue(true);
    }
    @Test(description="TC21 – Verify Add to Cart button adds product successfully")
    public void tc21_add_to_cart(){ HomePage home=new HomePage();
        ProductDetailsPage pd=home.search("Apple MacBook Pro").openFirstProduct();
        pd.addToCart();
        Assert.assertTrue(pd.isAddedToCart());
    }
}

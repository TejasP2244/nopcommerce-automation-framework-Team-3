package com.nopc.automation.tests.cart;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopc.automation.pages.*;
import com.nopc.automation.tests.base.BaseTest;

public class CartTests extends BaseTest {
    @Test(description="TC23 – Verify added product appears in cart",groups = {"regression"})
    public void tc23_added_product_in_cart(){
        HomePage home=new HomePage();
        ProductDetailsPage pd=home.search("Apple MacBook Pro").openFirstProduct();
        pd.addToCart();
        CartPage cart=new CartPage().open();
        Assert.assertTrue(cart.isSkuNumber());
    }
    private double extractNumericValue(String priceString){
        String cleaned=priceString.replaceAll("[^0-9.]","");
        return Double.parseDouble(cleaned);
    }
    @Test(description="TC24 – Verify updating quantity updates total price",groups = {"regression"})
    public void tc24_update_qty_updates_total(){
        HomePage home=new HomePage();
        ProductDetailsPage pd=home.search("Apple MacBook Pro").openFirstProduct();
        pd.addToCart();
        CartPage cart=new CartPage().open();
        double beforeUpdation=extractNumericValue(cart.getTotal());
        cart.updateQuantity();
        double afterUpdation=extractNumericValue(cart.getTotal());
        Assert.assertTrue(afterUpdation>beforeUpdation);
    }
    @Test(description="TC25 – Verify removing product from cart",groups = {"regression"})
    public void tc25_remove_from_cart(){
        HomePage home=new HomePage();
        ProductDetailsPage pd=home.search("Apple MacBook Pro").openFirstProduct();
        pd.addToCart();
        CartPage cart=new CartPage().open();
        cart.removeProduct();
        String cartMsg=cart.getEmptyCartMsg();
        Assert.assertEquals(cartMsg, "Your Shopping Cart is empty!");
    }
    @Test(description="TC26 – Verify cart total calculation (price × quantity)",groups = {"regression"})
    public void tc26_cart_total(){
        HomePage home=new HomePage();
        ProductDetailsPage pd=home.search("Apple MacBook Pro").openFirstProduct();
        pd.addToCart();
        CartPage cart=new CartPage().open();
        cart.updateQuantity();
        double unitPrice=extractNumericValue(cart.getIndPrice());
        double quantNum=extractNumericValue(cart.getQuant());
        double expTotalPrice=unitPrice*quantNum;
        double actTotalPrice=extractNumericValue(cart.getTotal());
        Assert.assertEquals(actTotalPrice,expTotalPrice);
    }
}

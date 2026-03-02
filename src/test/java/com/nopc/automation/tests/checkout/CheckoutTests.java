package com.nopc.automation.tests.checkout;

import org.testng.Assert;import org.testng.annotations.Test;import com.nopc.automation.pages.*;import com.nopc.automation.tests.base.BaseTest;

public class CheckoutTests extends BaseTest {
    @Test(description="TC27 – Verify user cannot checkout without login",groups = {"sanity"})
    public void tc27_cannot_checkout_without_login(){
        HomePage home=new HomePage();
        ProductDetailsPage pd=home.search("Apple MacBook Pro").openFirstProduct();
        pd.addToCart();
        CartPage cart=new CartPage().open();
        CheckoutPage co=cart.proceedToCheckout();
        Assert.assertTrue(co.loginRequired());
    }
    @Test(description="TC30 – Verify order confirmation after successful checkout",groups = {"sanity"})
    public void tc30_order_confirmation(){
        HomePage home=new HomePage();
        ProductDetailsPage pd=home.search("Apple MacBook Pro").openFirstProduct();
        pd.addToCart();
        CartPage cart=new CartPage().open();
        CheckoutPage co=cart.proceedToCheckout();
        co.guest();
        co.fillDetails();
        Assert.assertEquals(co.getSuccessMsg(),"Your order has been successfully processed!");
    }
}

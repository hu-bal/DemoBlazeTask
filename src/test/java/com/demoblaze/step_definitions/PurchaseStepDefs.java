package com.demoblaze.step_definitions;

import com.demoblaze.pages.CartPage;
import com.demoblaze.pages.PhonesPage;
import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.util.Map;

public class PurchaseStepDefs {


    PhonesPage phonesPage=new PhonesPage();
    CartPage cartPage=new CartPage();


    @Given("User is on the homePage")
    public void user_is_on_the_homePage() {
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("User navigates to {string} {string}")
    public void user_navigates_to(String category,String product) {
        BrowserUtils.waitFor(1);
        phonesPage.navigateTo(category,product);
    }

    @When("User clicks on {string}")
    public void user_clicks_on(String str) {
        cartPage.clickTo(str);
    }

    @When("User accepts pop up")
    public void user_accepts_pop_up() {
        BrowserUtils.waitFor(1);
        Alert alert = Driver.get().switchTo().alert();
        alert.accept();
    }

    @When("User deletes {string}")
    public void user_deletes(String deleteProduct) {
        BrowserUtils.waitFor(1);
        cartPage.delete(deleteProduct);
        BrowserUtils.waitFor(3);

    }


    @When("User fills following data")
    public void user_fills_following_data(Map<String,String> userInfo) {
    cartPage.name.sendKeys(userInfo.get("name"));
    cartPage.country.sendKeys(userInfo.get("country"));
    cartPage.city.sendKeys(userInfo.get("city"));
    cartPage.card.sendKeys(userInfo.get("card"));
    cartPage.month.sendKeys(userInfo.get("month"));
    cartPage.year.sendKeys(userInfo.get("year"));
    }


    @Then("User sees Purchase Id and Purchase Amount")
    public void user_sees_Purchase_Id_and_Purchase_Amount() {
        int id = cartPage.getID();
        int price = cartPage.getPrice();
        System.out.println("Id = " + id);
        System.out.println("Amount = " + price);

    }

    @Then("Purchase amount equals expected")
    public void purchase_amount_equals_expected() {
        int actualResult =  cartPage.getPrice();
        Assert.assertEquals(cartPage.getExpectedPrice(),actualResult);
    }











}

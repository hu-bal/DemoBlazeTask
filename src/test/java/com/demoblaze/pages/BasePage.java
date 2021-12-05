package com.demoblaze.pages;

import com.demoblaze.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }



    public void navigateTo(String categoryName,String productName){
        Driver.get().findElement(By.linkText(categoryName)).click();
        Driver.get().findElement(By.linkText(productName)).click();
    }

}

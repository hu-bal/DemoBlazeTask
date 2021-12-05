package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class CartPage extends BasePage{
    @FindBy(id = "name")
    public WebElement name;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(id = "city")
    public WebElement city ;

    @FindBy(id = "card")
    public WebElement card;

    @FindBy(id = "month")
    public WebElement month;

    @FindBy(id = "year")
    public WebElement year;


    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> table;


    @FindBy(xpath = "//body/div[10]/p[1]")
    public WebElement confirmationPupUpBox;

    @FindBy(xpath = "//h3")
    public WebElement productPrice;



    public void clickTo(String str){
        Driver.get().findElement(By.xpath("//*[text()='"+str+"']")).click();

    }


    public void delete(String deleteProduct){

        for (int i = 1; i <= table.size(); i++) {
            if (Driver.get().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[2]")).getText().equals(deleteProduct)) {
                BrowserUtils.waitFor(1);
                Driver.get().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[4]/a")).click();
                break;
            }
        }
    }


    public String getTextOfReport(){
        return confirmationPupUpBox.getText().replaceAll(" ","");
    }


    public int getID() {
        int indexOfAmount= getTextOfReport().indexOf("Amount");
        String id = getTextOfReport().substring(0,indexOfAmount).trim();
        int idNum = Integer.parseInt(id.replace("Id:",""));
        return idNum;
    }



    public int getPrice() {
        int indexOfCard = getTextOfReport().indexOf("Card");
        int indexOfAmount= getTextOfReport().indexOf("Amount");
        String amount = getTextOfReport().substring(indexOfAmount, indexOfCard).trim();
        int price = Integer.parseInt(amount.replace("Amount:", "").replace("USD","").trim());
        return price;
    }


    public int getExpectedPrice() {
        int price = Integer.parseInt(productPrice.getText());
        return price;
    }






}

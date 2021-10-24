package com.daver1107;

import com.daver1107.logic.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class StepDefinition extends SetUp {


    @Given("hm url {string}")
    public void hm_url(String url) {
        driver.get(url);
    }

    @When("I am on main page I accept all cookies")
    public void i_am_on_main_page_i_accept_all_cookies() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler"))).click();
//        driver.findElement(By.id("onetrust-accept-btn-handler"));
    }

    @Then("I type {string} in search filed")
    public void i_type_in_search_filed(String itemName) {
        WebElement searchField = driver.findElement(By.id("main-search"));
        searchField.sendKeys(itemName);
        searchField.submit();
    }

    @Then("I pick first item")
    public void pickRandomItem() {
        List <WebElement> searchResults = driver.findElements(By.xpath("//div[@class = 'image-container']"));
        int i = (int) (Math.random() * searchResults.size());
        searchResults.get(i).click();
    }

    @Then("I choose size")
    public void pickSize() {
        WebElement sizePicker = driver.findElement(By.xpath("//div[@class = 'picker small-picker item loaded']"));
        sizePicker.click();
        List<WebElement> sizes = driver.findElements(By.xpath("//li[@class = 'item  js-enable-nib']"));
        if (!isInStock()) {
            driver.navigate().back();
            pickRandomItem();
            pickSize();
        }
        else
        sizes.get(1).click();
    }

    @Then("click add to cart button")
    public void click_add_to_cart_button() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button [@class = 'item button fluid button-big button-buy']"))).click();
    }

    public boolean isInStock(){
        try {
            if (driver.findElement(By.xpath("//span[contains (text(), 'Нет в наличии')]")).getText().equals("Нет в наличии")) {
                return false;
            }
            else return true;
        }
        catch (NoSuchElementException e) {
            return true;
        }

    }
}

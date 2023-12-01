package com.shoppersstacks.qa.pages;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.text.View;
import java.awt.event.InputEvent;

public class HomePage extends TestBase{

    @FindBy(linkText = "Home")
    WebElement homeButton;
    @FindBy(id="search")
    WebElement serchBar;
    @FindBy(id="searchBtn")
    WebElement searchButton;
    @FindBy(css = "select[id='category' ]")
    WebElement categoryDropDown;
    @FindBy(id="cartIcon")
    WebElement viewCart;
    @FindBy (xpath = "//div[text()='C']")
    WebElement accountSettingIcon;
    @FindBy(xpath = "//img[@alt='APPLE iPhone 14 Pro']")
    WebElement item;
    @FindBy(id = "Add To Cart")
    WebElement add;
    @FindBy(xpath = "//button[text()='added']")
    WebElement addedButton;
    @FindBy (xpath = "//li[text()='My Profile']")
    WebElement prfile;
    @FindBy(xpath = "//li[text()='Wish List']")
    WebElement wishList;
    @FindBy(xpath = "//*[name()='svg' and @data-testid='ShoppingBagIcon']")
    WebElement myOrder;
    @FindBy(xpath = "//li[text()='My Wallet']")
    WebElement myWallet;
    @FindBy(xpath = "//li[text()='My Likes']")
    WebElement myLikes;
    @FindBy(xpath = "//li[text()='Logout']")
    WebElement logout;
    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    public String homePageTitle(){
       return driver.getTitle();
    }
    public void homeButton(){
        homeButton.click();
    }

    public void searchBar(String item)
    {
        serchBar.sendKeys(item);
        searchButton.click();
    }
    public void categoryDropDown(String choice)
    {
        Select select= new Select(categoryDropDown);
        switch (choice)
        {
            case "beauty":
            {
                select.selectByVisibleText("beauty");
            }
            break;
            case "men":
            {
                select.selectByVisibleText("men");
            }
            break;
            case "women":
            {
                select.selectByVisibleText("women");
            }
            case "kids":
            {
                select.selectByVisibleText("kids");
            }
            default:
            {
                select.selectByVisibleText("all");
            }
        }
    }

    public void electronics()
    {
        robot.mouseMove(850,220);
    }
    public void mobile(){
        robot.mouseMove(716,447);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(2000);
        robot.mouseMove(500,708);
        robot.delay(2000);
    }
    public void item(){
        wait.until(ExpectedConditions.elementToBeClickable(item)).click();
    }
    public void addToCart()
    {
        wait.until(ExpectedConditions.elementToBeClickable(add)).click();
    }
    public String added(){
        return addedButton.getText();
    }
    public ViewCartPage viewCart()
    {
        viewCart.click();
        return new ViewCartPage();
    }

    public void accountSettingIcon() {
        for (;;){
            try{
                action.moveByOffset(1446,43).click().perform();
                break;
            }
            catch (Exception e){
                js.executeScript("arguments[0].click()",accountSettingIcon);
                break;
            }
        }
    }
    public void profile() {
        prfile.click();
    }
    public void wishList(){
        wishList.click();
    }
    public void myWallet(){
        myWallet.click();
    }
    public void myLikes(){
        myLikes.click();
    }
    public LoginPage logout()
    {
        logout.click();
        return new LoginPage();
    }
    public MyOrdersPage myOrders(){
        myOrder.click();
        return new MyOrdersPage();
    }
}

package com.selenium.coursework.yahoopages;

import com.selenium.coursework.utils.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseDriver {

    @FindBy(name = "agree")
    private WebElement cookieWindow;

    @FindBy(xpath = "//span[contains(text(), 'Sign in')]")
    private WebElement signInBtn;

    @FindBy(id = "yfin-usr-qry")
    private WebElement searchField;

    @FindBy(id = "header-desktop-search-button")
    private WebElement searchBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement cookieWindow() {
        return cookieWindow;
    }

    public WebElement signInBtn() {
        return signInBtn;
    }

    public WebElement searchField() {
        return searchField;
    }

    public WebElement searchBtn() {
        return searchBtn;
    }
}

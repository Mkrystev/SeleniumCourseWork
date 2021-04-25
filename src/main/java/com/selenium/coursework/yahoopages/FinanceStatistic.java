package com.selenium.coursework.yahoopages;

import com.selenium.coursework.utils.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinanceStatistic extends BaseDriver {


    public FinanceStatistic(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td[@data-test='DIVIDEND_AND_YIELD-value']")
    private WebElement dividendAndYield;

    @FindBy(xpath = "//li[@data-test='STATISTICS']")
    private WebElement statistics;

    @FindBy(xpath = "//span[text()='Price/Book']/../following-sibling::td")
    private WebElement priceBook;

    public WebElement priceBook(){
        return priceBook;
    }
    public WebElement statistics(){
        return statistics;
    }
    public WebElement dividendAndYield(){
        return dividendAndYield;
    }

}

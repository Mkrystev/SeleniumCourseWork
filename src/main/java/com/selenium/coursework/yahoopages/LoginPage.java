package com.selenium.coursework.yahoopages;

import com.selenium.coursework.utils.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseDriver {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "createacc")
    private WebElement createAccBtn;

    public void createAccBtnClick() {
        createAccBtn.click();
    }
}

package com.softserve.edu.greencity.ui.pages.common;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.greencity.ui.tools.ForgotPasswordPart;

public class ForgotPasswordDropdown extends ForgotPasswordPart {

    WebDriver driver;

    public ForgotPasswordDropdown(WebDriver driver){
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        //TODO
    }
}
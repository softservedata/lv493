package com.softserve.edu.greencity.ui.pages.common;

import com.softserve.edu.greencity.ui.tools.ForgotPasswordPart;
import org.openqa.selenium.WebDriver;

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

package org.example.driversetup.enumeration;

import org.example.driversetup.invoker.WebDriverInvoker;
import org.example.driversetup.invoker.implementation.LocalChromeInvoker;
import org.example.driversetup.invoker.implementation.LocalFirefoxInvoker;
import org.openqa.selenium.WebDriver;

public enum SupportedBrowsers {
    LOCAL_CHROME(new LocalChromeInvoker()),
    LOCAL_FIREFOX(new LocalFirefoxInvoker());

    private final WebDriverInvoker WEB_DRIVER_INVOKER;

    SupportedBrowsers(WebDriverInvoker WEB_DRIVER_INVOKER) {
        this.WEB_DRIVER_INVOKER = WEB_DRIVER_INVOKER;
    }

    public WebDriver getWebDriver(){
        return WEB_DRIVER_INVOKER.invokeWebDriver();
    }
}

package org.example.driversetup.factory;

import org.example.driversetup.properties.converters.SupportedBrowserConverter;
import org.example.driversetup.properties.holder.PropertyHolder;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public WebDriver getWebDriver() {
        return SupportedBrowserConverter.valueOfWebBrowser(
                        new PropertyHolder().readProperty("browser"))
                .getWebDriver();
    }
}

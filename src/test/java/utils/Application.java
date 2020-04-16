package utils;

import org.openqa.selenium.WebDriver;

public class Application {
    private static ThreadLocal<DriverFactory> driverInstance = ThreadLocal.withInitial(DriverFactory::new);

    public static WebDriver getDriver() {
        return driverInstance.get().getDriver();
    }

    public static void closeDriver() {
        driverInstance.get().closeDriver();
    }
}
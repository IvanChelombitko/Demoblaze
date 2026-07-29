package ua.solvd.demoblaze.util;

import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class MobileContextService {
    private static final String NATIVE_CONTEXT = "NATIVE_APP";

    public static void switchContextToNative(WebDriver driver) {
        SupportsContextSwitching contextDriver = (SupportsContextSwitching) driver;
        contextDriver.context(NATIVE_CONTEXT);
    }

    public static void switchContextToWebView(WebDriver driver) {
        SupportsContextSwitching contextDriver = (SupportsContextSwitching) driver;
        Set<String> availableContexts = contextDriver.getContextHandles();
        String webviewContext = availableContexts.stream()
                .filter(context -> !context.equals(NATIVE_CONTEXT))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No web context found. Available contexts: " + availableContexts));
        contextDriver.context(webviewContext);
    }
}
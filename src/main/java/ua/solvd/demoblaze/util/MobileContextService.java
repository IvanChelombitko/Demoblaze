package ua.solvd.demoblaze.util;

import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class MobileContextService {
    private static final String NATIVE_CONTEXT = "NATIVE_APP";

    private static SupportsContextSwitching getContextDriver(WebDriver driver) {
        return (SupportsContextSwitching) driver;
    }

    public static void switchContextToNative(WebDriver driver) {
        getContextDriver(driver).context(NATIVE_CONTEXT);
    }

    public static void switchContextToWebView(WebDriver driver) {
        Set<String> availableContexts = getContextDriver(driver).getContextHandles();
        String webviewContext = availableContexts.stream()
                .filter(context -> context.startsWith("WEBVIEW") || context.equals("CHROMIUM"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No web context found. Available contexts: " + availableContexts));
        getContextDriver(driver).context(webviewContext);
    }
}
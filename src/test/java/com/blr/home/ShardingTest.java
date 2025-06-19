package com.blr.home;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShardingTest {

    @Test
    public void testPlaywrightSharding() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newContext().newPage();

            // Start tracing
            page.context().tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true));

            String url = page.navigate("https://www.example.com").url();
            assertEquals("https://www.example.com/", url);

            // Take a screenshot and save it to the "screenshots" directory
            page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("build/reports/screenshots/example.png")));

            // Stop tracing and save the trace file
            page.context().tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("build/reports/trace.zip")));
        }
    }
}
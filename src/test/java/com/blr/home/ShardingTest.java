package com.blr.home;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShardingTest {

    @Test
    public void testPlaywrightSharding() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newContext().newPage();
            String url = page.navigate("https://www.example.com").url();
            assertEquals("https://www.example.com/", url);
        }
    }
}
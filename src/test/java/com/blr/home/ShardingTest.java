package com.blr.home;

import com.microsoft.playwright.Playwright;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShardingTest {

    @Test
    public void testPlaywrightSharding() {
        try (Playwright playwright = Playwright.create()) {
            String url = playwright.chromium().launch()
                    .newContext()
                    .newPage()
                    .navigate("https://www.example.com")
                    .url();
            assertEquals("https://www.example.com", url);
        }
    }
}
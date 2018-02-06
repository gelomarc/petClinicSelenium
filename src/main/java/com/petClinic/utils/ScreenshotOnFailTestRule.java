package com.petClinic.utils;

import com.petClinic.pages.BasePage;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class ScreenshotOnFailTestRule extends TestWatcher {


    private final BasePage steps;

    public ScreenshotOnFailTestRule(BasePage steps) {
        this.steps = steps;
    }

    @Override
    protected void failed(Throwable e, Description description) {
        steps.makeScreenshotAndAddFailingURLtoLogs();
    }
}

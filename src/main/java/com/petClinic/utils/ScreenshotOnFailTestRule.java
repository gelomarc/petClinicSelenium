package com.petClinic.utils;

import com.petClinic.steps.WebDriverSteps;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class ScreenshotOnFailTestRule extends TestWatcher {


    private final WebDriverSteps steps;

    public ScreenshotOnFailTestRule(WebDriverSteps steps) {
        this.steps = steps;
    }

    @Override
    protected void failed(Throwable e, Description description) {
        steps.makeScreenshotAndAddFailingURLtoLogs();
    }
}

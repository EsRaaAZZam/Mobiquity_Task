package com.mobiquity_task.tests;

import com.mobiquity_task.utils.extent_report.ExtentReport;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksHandler extends BaseTest {


    @Before(order = 1)
    public void startTCHooks(Scenario scenario) {
        ExtentReport.setScenario(scenario);
        ExtentReport.startTC();
    }

    @Before(order = 2)
    public void setStepDefs() throws NoSuchFieldException, IllegalAccessException {
        ExtentReport.setStepDefs();
    }


    @After(order = 1)
    public void endTC() {
        ExtentReport.getExtent().endTest(ExtentReport.getTest());
        ExtentReport.getExtent().flush();
    }


    @AfterStep
    public void AfterStep(Scenario scenario) {
        String stepName = ExtentReport.getCurrentStepName();
        LogStatus logStatus;

        if (scenario.isFailed())
            logStatus = LogStatus.FAIL;
        else
            logStatus = LogStatus.PASS;

    }
}

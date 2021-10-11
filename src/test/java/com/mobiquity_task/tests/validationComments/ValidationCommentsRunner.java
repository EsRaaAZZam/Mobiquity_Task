package com.mobiquity_task.tests.validationComments;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/nagwa_task/tests/validationComments",
        glue = {"com.mobiquity_task.tests"},
        plugin = {"html:reports/countQuestions-Report.html"},
        monochrome = true
)
public class ValidationCommentsRunner extends AbstractTestNGCucumberTests {
}

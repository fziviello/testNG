package com.academy;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        tags= {"@user,@calculator"},
        glue = "com.academy.cucumber.steps",
        plugin = { "html:testreportdir", "json:testreportdir/testreport.json" }
)
public class RunCucumberTest {}

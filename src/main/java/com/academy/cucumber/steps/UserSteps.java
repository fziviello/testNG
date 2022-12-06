package com.academy.cucumber.steps;

import com.academy.cucumber.models.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class UserSteps {

    private User user = new User();

    @Given("^that the user (.*) is given a task to clear (.*) certification exam$")
    public void certificationName(String name, String certication){
        user.setName(name);
        user.setCertification(certication);
    }

    @When("^(.*) got (\\d+) marks in exam$")
    public void gotMarks(String name, int marks) {
        user.setName(name);
        user.setMarks(marks);
    }

    @Then("^(.*) is known as (.*) certified$")
    public void certifiedYes(String name, String certification) {
        assertThat(name, is(user.getName()));
        assertThat(user.getCertification(), equalTo(certification));
        assertThat(user.getResult(), is(true));
    }
}

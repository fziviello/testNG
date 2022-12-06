package com.academy.cucumber.steps;

import com.academy.unit.Calculator;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorSteps {

    private Calculator calculator = new Calculator();
    private ArrayList<Integer> listResult = new ArrayList<>();

    private int a = 0;
    private int b = 0;
    private int num = 0;

    @Given("^two numbers (.*) and (.*)$")
    public void checkNumbers(int a, int b){
        try {
            this.a = Integer.parseInt(String.valueOf(a));
            this.b = Integer.parseInt(String.valueOf(b));
        } catch (NumberFormatException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Then("^the sum is (.*)$")
    public void sum(int result) {
        assertThat(result, is(calculator.sum(this.a,this.b)));
    }

    @Then("^the difference is (.*)$")
    public void diff(int result) {
        assertThat(result, is(calculator.diff(this.a,this.b)));
    }

    @Then("^the multiply is (.*)$")
    public void mpy(int result) {
        assertThat(result, is(calculator.mpy(this.a,this.b)));
    }

    @When("^load sum dataTable$")
    public void sumDataTable(DataTable dataTable) {
        Map<Integer,Integer> mapTable = dataTable.asMap(Integer.class,Integer.class);
        for(int key: dataTable.asMap(Integer.class,Integer.class).keySet()){
            this.listResult.add(calculator.sum(key,mapTable.get(key)));
        }
    }

    @Then("^check the sum result$")
    public void checkSumDataTable(DataTable dataTable) {
        assertThat(listResult, is(dataTable.asList(Integer.class)));
    }

    @Given("^try the number (.*)$")
    public void isPrime(int num) {
        this.num = num;
    }

    @Then("^is prime(.*)$")
    public void isPrime(boolean status) {
        assertThat(status, is(calculator.isPrime(this.num)));
    }
}

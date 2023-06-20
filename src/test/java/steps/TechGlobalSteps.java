package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormPage;
import utils.Driver;

public class TechGlobalSteps {

    WebDriver driver;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    TechGlobalLoginFormPage techGlobalLoginFormPage;

    @Before
    public  void setDriver(){
        driver = Driver.getDriver();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();

    }

    @Given("user selects the {string} option")
    public void user_selects_the_option(String option) {
        techGlobalFrontendTestingHomePage.clickOnCard(option);
    }
    @Then("user should see {string} heading")
    public void user_should_see_heading(String headerText) {
        Assert.assertEquals(headerText, techGlobalLoginFormPage.headingText.getText());
    }
    @When("user enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String username, String password) {
        techGlobalLoginFormPage.usernameInput.sendKeys(username);
        techGlobalLoginFormPage.passwordInput.sendKeys(password);
        techGlobalLoginFormPage.loginButton.click();
    }
    @Then("user should see a {string} message")
    public void user_should_see_a_message(String errorMessage) {

        switch (errorMessage) {
            case "Invalid Username entered!":
                Assert.assertEquals(errorMessage, techGlobalLoginFormPage.error.getText());
                break;
            case "You are logged in":
                Assert.assertEquals(errorMessage, techGlobalLoginFormPage.successLogin.getText());
                break;
            default:
                throw new NotFoundException("The error message is not defined properly in the feature file");
        }
    }
}
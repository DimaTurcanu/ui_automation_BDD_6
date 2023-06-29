package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.Project05Page;
import utils.Driver;

public class Project05Steps {

    WebDriver driver;
    Project05Page project05Page;


    @Before
    public void setDriver(){
        driver = Driver.getDriver();
        project05Page = new Project05Page();
    }

    @Then("the user should see the {string} heading")
    public void theUserShouldSeeThePaginationHeadingAndSubheading(String heading) {

        switch (heading){
            case "Pagination":
        Assert.assertTrue(project05Page.heading.isDisplayed());
        Assert.assertEquals(project05Page.heading.getText(), heading);
        break;
            case "World City Populations 2022":
        Assert.assertTrue(project05Page.subHeading.isDisplayed());
        Assert.assertEquals(project05Page.subHeading.getText(), heading);
        break;
            default:

        }
    }



    @And("the user should see the {string} paragraph")
    public void theUserShouldSeeTheWhatAreTheMostPopulatedCitiesInTheWorld(String content) {

        Assert.assertTrue(project05Page.content.isDisplayed());
        Assert.assertEquals(project05Page.content.getText(), content);
    }


    @Then("the user should see the {string} button is disabled")
    public void the_user_should_see_the_button_is_disabled(String string) {
        switch (string) {
            case "Previous":
                Assert.assertFalse(project05Page.previous.isEnabled());
                break;
            case "Next":
                Assert.assertFalse(project05Page.next.isEnabled());
                break;
            default:
        }

    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheNextButton(String str) {
        if (str.equals("Next")) {
            project05Page.next.click();
        }
    }

    @When("the user clicks on the {string} button till it becomes disabled")
    public void the_user_clicks_on_the_button_till_it_becomes_disabled(String str) {
        if (str.equals("Next")) {

            while (project05Page.next.isEnabled()) {

                project05Page.next.click();
            }
            Assert.assertFalse(project05Page.content.isEnabled());
        }
    }

    @And("the user should see the {string} button is enabled")
    public void the_user_should_see_the_next_button_is_enabled(String button) {
        switch (button) {
            case "Previous":
                Assert.assertTrue(project05Page.previous.isEnabled());
                break;
            case "Next":
                Assert.assertTrue(project05Page.next.isEnabled());
                break;
            default:
        }

    }

    @Then("the user should see “Delhi” City with the info below and an image")
    public void theUserShouldSeeDelhiCityWithTheInfoBelowAndAnImage() {

    }

    @Then("the user should see “Tokyo” City with the info below and an image")
    public void theUserShouldSeeTokyoCityWithTheInfoBelowAndAnImage() {
    }

    @When("the user clicks on the “Next” button")
    public void theUserClicksOnTheNextButton() {
    }

    @Then("the user should see “Shangai“ City with the info below and an image")
    public void theUserShouldSeeShangaiCityWithTheInfoBelowAndAnImage() {
    }

    @Then("the user should see “Sao Paulo“ City with the info below and an image")
    public void theUserShouldSeeSaoPauloCityWithTheInfoBelowAndAnImage() {
    }

    @Then("the user should see “Mexico City” City with the info below and an image")
    public void theUserShouldSeeMexicoCityCityWithTheInfoBelowAndAnImage() {
    }
}

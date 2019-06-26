package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {
    @Given("^Google search is opened in my browser$")
    public void googleSearchIsOpenInMyBrowser() throws Throwable {
        open("http://www.google.com");
    }

    @When("^I enter search term \"([^\"]*)\"$")
    public void iEnterSearchTerm(String arg0) throws Throwable {
        $("[name=q]").sendKeys(arg0 + Keys.ENTER);
    }

    @Then("^Search results contains links for \"([^\"]*)\" related resources$")
    public void searchResultsContainsLinksForRelatedResources(String arg0) throws Throwable {
        $("h3").shouldHave(Condition.text(arg0));
    }
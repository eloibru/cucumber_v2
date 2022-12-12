package steps;

import Actions.Commons_Actions;
import Actions.EbayAdvancedSearch_Actions;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.fail;

public class AdvancedSearch_Steps {

    static final Logger logger = LogManager.getLogger(AdvancedSearch_Steps.class);

    Commons_Actions commons_actions;
    EbayAdvancedSearch_Actions ebayAdvancedSearch_actions;

    private ObjectMapper objectMapper = new ObjectMapper();


    public AdvancedSearch_Steps( Commons_Actions commons_actions, EbayAdvancedSearch_Actions ebayAdvancedSearch_actions) {
        this.commons_actions = commons_actions;
        this.ebayAdvancedSearch_actions = ebayAdvancedSearch_actions;
    }

    @Given("I am on ebay advanced search page")
    public void i_am_on_ebay_advanced_search_page()  {
        logger.info("i_am_on_ebay_advanced_search_page test");
        commons_actions.goToUrl("https://www.ebay.com/sch/ebayadvsearch");
    }

    @When("i click on the ebay logo")
    public void i_click_on_the_ebay_logo() throws InterruptedException {
        Thread.sleep(1000);

        commons_actions.maximize();
        commons_actions.clickGdpr();
        ebayAdvancedSearch_actions.clickOnLogo();
    }

    @Then("I navigate to the Ebay home page")
    public void i_navigate_to_the_ebay_home_page() {
        String expectedUrl = "https://www.ebay.com/";
        String actualUrl = commons_actions.getCurrentUrl(); //webDriver.getCurrentUrl();
        if (!actualUrl.equals(expectedUrl))
            fail("Page " + actualUrl + " not navigat to " + expectedUrl);
    }




    @When("I advance search an item")
    public void i_advance_search_an_item() throws InterruptedException {
        Thread.sleep(1000);
        commons_actions.maximize();
        commons_actions.clickGdpr();
    }

    @Then("I validate at least {int} items are present in advance search")
    public void i_validate_at_least_items_are_present(int expected) {
        if (commons_actions.getItemCount() < expected)
            fail("itemCount  is less then exepcted");

    }

    @When("I use {string} as searchCriteria")
    public void I_use_advance_search_criteria(String criteria) {
        ebayAdvancedSearch_actions.searchItem(criteria);
    }

    @When("I use as searchCriteria")
    public void i_use_as_search_criteria(DataTable dataTable) {
        ebayAdvancedSearch_actions.search(dataTable.cell(1,0), dataTable.cell(1,1), dataTable.cell(1,2), dataTable.cell(1,3));
    }

    @When("I use {string} as exclusion")
    public void I_use_advance_search_exclusion(String exclusion) {
        ebayAdvancedSearch_actions.excludeItem(exclusion);


    }

    @When("I use {int} as priceMin")
    public void I_use_advance_search_price_min(int priceMin) {
        ebayAdvancedSearch_actions.setMinPrice(priceMin+"");
    }

    @When("I use {int} as priceMax")
    public void I_use_advance_search_price_max(int priceMax) {
        ebayAdvancedSearch_actions.setMaxPrice(priceMax+"");
    }


    @When("I click search")
    public void i_click_search() throws InterruptedException {
        ebayAdvancedSearch_actions.clickAdvanceSearchButon();
        Thread.sleep(1000);
    }


    @When("i_advance_search_an_item_via_person")
    public void i_advance_search_an_item_2(DataTable dataTable) throws InterruptedException {

        List<Map<String, String>> values = dataTable.asMaps(String.class, String.class);
        List<SearchCriteria> inputs = values.stream().map(i -> objectMapper.convertValue(i, SearchCriteria.class)).collect(Collectors.toList());

        ebayAdvancedSearch_actions.search(inputs.get(0).getInclude(), inputs.get(0).getExclude(), inputs.get(0).getMinPrice()  +"", inputs.get(0).getMaxPrice() + "");
        Thread.sleep(1000);
    }



    @Then("I search for {string} and exclude {string} with a minimum price of {string} and a maximum price {string}")
    public void i_navigate_to_and_title_contains_and_exclude_with_a_minimum_price_of_and_a_maximum_price(String include, String exclude, String minPrice, String maxPrice) {
        ebayAdvancedSearch_actions.search(include, exclude, minPrice, maxPrice);
    }
    @Then("I validate at least {string} items are present in advance search")
    public void i_validate_at_least_items_are_present_in_advance_search(String string) {
        if (commons_actions.getItemCount() <  Integer.parseInt(string))
            fail("Item is less then exepcted");
    }
}

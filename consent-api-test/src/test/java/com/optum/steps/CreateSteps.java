package com.optum.steps;

import com.optum.model.Consent;
import com.optum.utils.JsonReader;
import com.optum.world.WorldHelper;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

import static org.junit.Assert.*;

public class CreateSteps {

    private WorldHelper helper;

    public CreateSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I have access to consent service$")
    public void iHaveAccessToConsentService() {
        helper.baseVerb().setUp();
    }

    @When("^I create a consent using \"([^\"]*)\"$")
    public void iCreateAConsentUsing(String payloadJson) throws Throwable {
        payloadJson = JsonReader.getData(payloadJson);
        helper.postVerb().postOnApi("/invitation-code", payloadJson);
    }


    @Then("^the following create consent result is available$")
    public void theFollowingCreateConsentResultIsAvailable() {
        Response response = helper.postVerb().getResponse();
        //Status Code
        assertEquals(response.getStatusCode(), 201);
        //Get time
        assertTrue(response.getTime() <= 10000);
        response.then().contentType(ContentType.JSON);
        //Body Information
        Consent consent = response.as(Consent.class, ObjectMapperType.GSON);


        assertNotNull(consent.getId());
        assertNotNull(consent.getCode());
        assertNotNull(consent.getBirthDate());
        assertNotNull(consent.getParticipantId());
        assertNotNull(consent.getStudyId());
        assertNotNull(consent.isUse());
        assertNotNull(consent.getUpdatedAt());
    }

    @Then("^the following create consent invalid result is available$")
    public void theFollowingCreateConsentInvalidResultIsAvailable() {
        Response response = helper.postVerb().getResponse();
        //Status Code
        System.out.println(response.getStatusCode());
        // assertEquals(response.getStatusCode(), 400);
    }

}

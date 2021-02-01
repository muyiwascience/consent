package com.optum.steps;

import com.optum.model.Consent;
import com.optum.utils.JsonReader;
import com.optum.world.WorldHelper;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

public class RetrieveSteps {
    private WorldHelper helper;

    public RetrieveSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I retrieve a consent using on \"([^\"]*)\"$")
    public void iRetrieveAConsentUsingOn(String endpoint) throws Throwable {
        helper.getVerb().getApi(endpoint);
    }

    @Then("^the following get consent result is available$")
    public void theFollowingGetConsentResultIsAvailable() {
        Response response = helper.getVerb().getResponse();
        //Status Code
        assertEquals(response.getStatusCode(), 200);

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
    }
}

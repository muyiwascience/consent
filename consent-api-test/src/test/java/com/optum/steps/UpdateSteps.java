package com.optum.steps;


import com.optum.model.Consent;
import com.optum.utils.JsonReader;
import com.optum.world.WorldHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

public class UpdateSteps {

    private WorldHelper helper;


    public UpdateSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I update a consent using \"([^\"]*)\" on \"([^\"]*)\"$")
    public void iUpdateAConsentUsingOn(String payloadJson, String endpoint) throws Throwable {
        payloadJson = JsonReader.getData(payloadJson);
        helper.putVerb()
                .putOnApi("/invitation-code/"+endpoint, payloadJson);
    }


    @Then("^the following update consent result is available$")
    public void theFollowingUpdateConsentResultIsAvailable() {
        Response response = helper.putVerb().getResponse();
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

    @Then("^the following update consent invalid result is available$")
    public void theFollowingUpdateConsentInvalidResultIsAvailable() {
        Response response = helper.putVerb().getResponse();
        //Status Code
        assertEquals(response.getStatusCode(), 404);
    }
}

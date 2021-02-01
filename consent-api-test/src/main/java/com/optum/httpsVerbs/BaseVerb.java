package com.optum.httpsVerbs;

import com.optum.utils.Props;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseVerb {

    protected RequestSpecification requestSpecification;

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public RequestSpecification setUp(){
        RestAssured.baseURI = Props.getValue("base.uri");
        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = given()
                .accept("application/json")
                .contentType("application/json")
                .and();
        return requestSpecification;
  }
}

package com.optum.httpsVerbs;

import io.restassured.response.Response;

public class PutVerb extends BaseVerb{

    private Response response;

    public Response getResponse() {
        return response;
    }

    public Response putOnApi(String uri, String body){
        response = setUp().body(body).put(uri);
        return response;
    }
}

package com.optum.httpsVerbs;

import io.restassured.response.Response;

public class DeleteVerb extends BaseVerb{

    private Response response;

    public Response getResponse() {
        return response;
    }

    public Response deleteOnApi(String uri, String body){
        response = setUp().body(body).put(uri);
        return response;
    }
}

package com.optum.world;

import com.optum.httpsVerbs.*;

public class WorldHelper {

    private static BaseVerb baseVerb;
    private static GetVerb getVerb;
    private static PostVerb postVerb;
    private static PutVerb putVerb;
    private static DeleteVerb deleteVerb;

    public BaseVerb baseVerb() {
        if(baseVerb != null) return baseVerb;
        baseVerb = new BaseVerb();
        return baseVerb;
    }


    public GetVerb getVerb() {
        if(getVerb != null) return getVerb;
        getVerb = new GetVerb();
        return getVerb;
    }

    public PostVerb postVerb() {
        if(postVerb != null) return postVerb;
        postVerb = new PostVerb();
        return postVerb;
    }

    public PutVerb putVerb() {
        if(putVerb != null) return putVerb;
        putVerb = new PutVerb();
        return putVerb;
    }

    public DeleteVerb deleteVerb() {
        if(deleteVerb != null) return deleteVerb;
        deleteVerb = new DeleteVerb();
        return deleteVerb;
    }



}

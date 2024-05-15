package com.frostbrain2020.utils;

import io.restassured.filter.cookie.CookieFilter;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class RequestUtils {
    static CookieFilter cookieFilter = new CookieFilter();

    public static RequestSpecification getBaseRequestSpecification(){
        return SerenityRest.given()
                .filter(cookieFilter)
                .relaxedHTTPSValidation()
                .log()
                .all();
    }



}

package com.tobe.keycloak.service;

import com.tobe.keycloak.common.ApiClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserApiService {
    private static final Logger logger = LoggerFactory.getLogger(UserApiService.class);

    public void test (){
        ApiClientUtil apiClientUtil = new ApiClientUtil();
        String response =  apiClientUtil.request("GET","https://jsonplaceholder.typicode.com/posts",null);
        logger.info(response);
    }
}

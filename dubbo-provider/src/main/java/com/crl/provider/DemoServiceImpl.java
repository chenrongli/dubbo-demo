package com.crl.provider;

import com.crl.api.DemoService;

/**
 * 1
 */
public class DemoServiceImpl implements DemoService {

    @Override
    public String hello(String string) {
        // TODO Auto-generated method stub
        return "hello consumer, " + string;
    }

}

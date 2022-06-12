package com.wing.ecommerce.utility;

public class Helper {
    public static final String routePrefix = "/api/v1";

    public static Integer randomInteger(Integer max, Integer min){
        if(min == null) min = 0;

        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }
}

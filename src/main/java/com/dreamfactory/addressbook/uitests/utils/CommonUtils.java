package com.dreamfactory.addressbook.uitests.utils;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by ikorol on 01.12.2016.
 */
public class CommonUtils {
    public static String uniquePrefix(){
        return RandomStringUtils.random(10, true, true);
    }
}

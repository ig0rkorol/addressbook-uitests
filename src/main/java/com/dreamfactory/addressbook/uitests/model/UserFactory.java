package com.dreamfactory.addressbook.uitests.model;

import com.dreamfactory.addressbook.uitests.utils.CommonUtils;

/**
 * Created by ikorol on 30.11.2016.
 */
public class UserFactory {
    public static User getUniqueUser(){
        return new User.Builder()
                .firstName("Fname").lastName("Lname")
                .email(CommonUtils.uniquePrefix()+"@gmail.com").password("123456").build();
    }
    public static User getExistingUser(){
        return new User.Builder()
                .firstName("Fname").lastName("Lname")
                .email("ki01@gmail.com").password("123456").build();
    }

    public static User getUserWithInvalidEmail(){
        return new User.Builder()
                .firstName("Fname").lastName("Lname")
                .email("ki01@gmail.com").password("123456").build();
    }

    public static User getUserWithoutEmail(){
        return new User.Builder()
                .firstName("Fname").lastName("Lname")
                .email("").password("123456").build();
    }

    public static User getUserWithoutPassword(){
        return new User.Builder()
                .firstName("Fname").lastName("Lname")
                .email("").password("123456").build();
    }

    public static User getUserWithPasswordThreeSymbolsLength(){
        return new User.Builder()
                .firstName("Fname").lastName("Lname")
                .email(CommonUtils.uniquePrefix()+"@gmail.com").password("123").build();
    }

    public static User getUserWithBlankOptionalFields() {
        return new User.Builder()
                .firstName("").lastName("")
                .email(CommonUtils.uniquePrefix()+"@gmail.com").password("123456").build();
    }
}

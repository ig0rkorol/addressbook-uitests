package com.dreamfactory.addressbook.uitests.model;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ikorol on 30.11.2016.
 */
public class User {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String password;

        public Builder firstName(String value) {
            firstName = value;
            return this;
        }
        public Builder lastName(String value) {
            lastName = value;
            return this;
        }
        public Builder email(String value) {
            email = value;
            return this;
        }
        public Builder password(String value) {
            password = value;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }
    private User(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public String convertToXwwwForm(){
        String resultString = StringUtils.EMPTY;
        Map<String, String> userData = new HashMap<>();
        userData.put("first_name", getFirstName());
        userData.put("last_name", getLastName());
        userData.put("email", getEmail());
        userData.put("password", getPassword());
        for(Map.Entry <String, String> entry : userData.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            if (StringUtils.isNoneEmpty(value)){
                if(resultString.length()>0){
                    resultString+="&";
                }
                resultString+=key + "=" + value;
            }
        }
        return resultString;
    }

    @Override
    public String toString() {
        return convertToXwwwForm();
    }
}

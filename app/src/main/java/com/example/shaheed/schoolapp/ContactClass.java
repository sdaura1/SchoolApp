package com.example.shaheed.schoolapp;

/**
 * Created by shaheed on 10/16/17.
 */

public class ContactClass {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getImageURL() {
        return ImageURL;
    }

    public void setImageURL(Integer imageURL) {

        ImageURL = imageURL;
    }
    public void setPhoneNumber(String phoneNumber){
        PhoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return PhoneNumber;
    }

    String Name;
    Integer ImageURL;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    Integer id;
    String PhoneNumber;

}

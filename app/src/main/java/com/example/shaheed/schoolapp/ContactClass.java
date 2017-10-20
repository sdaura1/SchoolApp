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

    public String getWords() {
        return word;
    }

    public void setWords(String words) {

        word = words;
    }
    public void setPhoneNumber(String phoneNumber){
        PhoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return PhoneNumber;
    }

    String Name;
    String word;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    Integer id;
    String PhoneNumber;

}

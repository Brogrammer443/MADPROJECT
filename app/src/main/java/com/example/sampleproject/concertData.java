package com.example.sampleproject;

public class concertData
{
    private String username;
    private String userPhone;
    private String userEmail;
    private String Singer;


    public concertData(String username, String userPhone, String userEmail, String Singer)
    {
        this.username = username;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.Singer = Singer;
    }

    public String getUsername() {
        return username;
    }


    public String getSinger() {
        return Singer;
    }


    public String getUserPhone() {
        return userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }



    public void setSinger(String Movie) {
        this.Singer = Singer;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}

package com.example.sampleproject;

public class AirlineData
{
    private String username;
    private String userPhone;
    private String userEmail;
    private String Dcountry;
    private String Acountry;
    private String AirlineSelection;


    public AirlineData(String username, String userPhone, String userEmail, String Dcountry, String Acountry
            ,String AirlineSelection)
    {
        this.username = username;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.Acountry = Acountry;
        this.Dcountry = Dcountry;
        this.AirlineSelection = AirlineSelection;
    }

    public String getUsername() {
        return username;
    }

    public String getDcountry() {
        return Dcountry;
    }

    public String getAcountry() {
        return Acountry;
    }

    public String getAirlineSelection() {
        return AirlineSelection;
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

    public void setAirlineSelection(String AirlineSelection)
    {
        this.AirlineSelection = AirlineSelection;
    }

    public void setAcountry(String Acountry) {
        this.Acountry = Acountry;
    }

    public void setDcountry(String Dcountry)
    {
        this.Dcountry = Dcountry;

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}

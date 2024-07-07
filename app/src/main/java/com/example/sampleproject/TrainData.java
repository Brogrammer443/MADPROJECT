package com.example.sampleproject;

public class TrainData {
    private String username;
    private String userPhone;
    private String userEmail;
    private String Dcity;
    private String Acity;
    private String TrainSelection;


    public TrainData(String username, String userPhone, String userEmail, String Dcity, String Acity
            ,String TrainSelection)
    {
        this.username = username;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.Acity = Acity;
        this.Dcity = Dcity;
        this.TrainSelection = TrainSelection;
    }

    public String getUsername() {
        return username;
    }

    public String getDcity() {
        return Dcity;
    }

    public String getAcity() {
        return Acity;
    }

    public String getTrainSelection() {
        return TrainSelection;
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

    public void setTrainSelection(String trainSelection) {
        TrainSelection = trainSelection;
    }

    public void setAcity(String acity) {
        Acity = acity;
    }

    public void setDcity(String dcity) {
        Dcity = dcity;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}

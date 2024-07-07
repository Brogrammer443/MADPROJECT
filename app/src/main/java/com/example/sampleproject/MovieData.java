package com.example.sampleproject;

public class MovieData
{
    private String username;
    private String userPhone;
    private String userEmail;
    private String Movie;
    private String SeatNo;


    public MovieData(String username, String userPhone, String userEmail, String Movie, String SeatNo)
    {
        this.username = username;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.Movie = Movie;
        this.SeatNo = SeatNo;
    }

    public String getUsername() {
        return username;
    }

    public String getSeatNo() {
        return SeatNo;
    }

    public String getMovie() {
        return Movie;
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



    public void setMovie(String Movie) {
        this.Movie = Movie;
    }

    public void setSeatNo(String SeatNo)
    {
        this.SeatNo = SeatNo;

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}

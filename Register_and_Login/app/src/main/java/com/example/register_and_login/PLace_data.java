package com.example.register_and_login;

public class PLace_data {
    private String place_name;
    private String place_country;
    private Integer place_image;

    public PLace_data(String place_name, String place_country, Integer place_image) {
        this.place_name = place_name;
        this.place_country = place_country;
        this.place_image = place_image;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getPlace_country() {
        return place_country;
    }

    public void setPlace_country(String place_country) {
        this.place_country = place_country;
    }

    public Integer getPlace_image() {
        return place_image;
    }

    public void setPlace_image(Integer place_image) {
        this.place_image = place_image;
    }
}

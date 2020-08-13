package com.example.expandablecollapse;

public class Movie {

    private String category,name,imageurl;

    public Movie(String category,String name,String imageurl) {
        this.category=category;
        this.name = name;
        this.imageurl=imageurl;


    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }


}
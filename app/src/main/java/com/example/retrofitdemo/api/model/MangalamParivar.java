package com.example.retrofitdemo.api.model;

/**
 * Created by komal on 04-04-2017.
 */

public class MangalamParivar {

    private int MangalamParivarID;
    private String Name;
    private String Address;
    private String Description;
    private String Image;

    public int getMangalamParivarID() {
        return MangalamParivarID;
    }

    public void setMangalamParivarID(int mangalamParivarID) {
        MangalamParivarID = mangalamParivarID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}

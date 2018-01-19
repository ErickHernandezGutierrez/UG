package app.ug;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class Memory {
    //Members
    private String date;
    private String campus;
    private String title;
    private String description;
    private ArrayList<String> links;
    private ArrayList<Bitmap> images;

    //Constructors
    public Memory(){}
    public Memory(String date, String campus, String title, String description, ArrayList<String> links, ArrayList<Bitmap> images) {
        this.date = date;
        this.campus = campus;
        this.title = title;
        this.description = description;
        this.links = links;
        this.images = images;
    }
    public Memory(String date, String campus, String title, String description) {
        this.date = date;
        this.campus = campus;
        this.title = title;
        this.description = description;
    }

    //Setters
    public void setDate(String date) {
        this.date = date;
    }
    public void setCampus(String campus) {
        this.campus = campus;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setLinks(ArrayList<String> links) {
        this.links = links;
    }
    public void setImages(ArrayList<Bitmap> images){
        this.images = images;
    }

    //Getters
    public String getDate() {
        return this.date;
    }
    public String getCampus() {
        return this.campus;
    }
    public String getTitle() {
        return this.title;
    }
    public String getDescription() {
        return this.description;
    }
    public ArrayList<String> getLinks() {
        return this.links;
    }
    public ArrayList<Bitmap> getImages(){
        return this.images;
    }
}

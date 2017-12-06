package app.ug;

import android.graphics.Bitmap;
import java.util.Date;

public class Banner {
    //Members
    private String title;
    private Bitmap image;
    private Date date;
    private int imageID;
    private int tag;

    //Constructors
    public Banner(){}
    public Banner(String title, Bitmap image, Date date, int imageID, int tag){
        this.title = title;
        this.image = image;
        this.date = date;
        this.imageID = imageID;
        this.tag = tag;
    }
    public Banner(String title, int imageID, int tag){
        this.title = title;
        this.imageID = imageID;
        this.tag = tag;
    }

    //Setters
    public void setTitle(String title){
        this.title = title;
    }
    public void setImage(Bitmap image){
        this.image = image;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public void setImageID(int imageID){
        this.imageID = imageID;
    }
    public void setTag(int tag){
        this.tag = tag;
    }

    //Getters
    public String getTitle(){
        return this.title;
    }
    public Bitmap getImage(){
        return this.image;
    }
    public Date getDate(){
        return this.date;
    }
    public int getImageID(){
        return this.imageID;
    }
    public int getTag(){
        return this.tag;
    }
}

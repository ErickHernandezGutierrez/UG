package app.ug;

public class Banner {
    //Members
    private String name;
    private int imageID;
    private int tag;

    //Constructors
    public Banner(){}
    public Banner(String name, int imageID, int tag){
        this.name = name;
        this.imageID = imageID;
        this.tag = tag;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setImageID(int imageID){
        this.imageID = imageID;
    }
    public void setTag(int tag){
        this.tag = tag;
    }

    //Getters
    public String getName(){
        return this.name;
    }
    public int getImageID(){
        return this.imageID;
    }
    public int getTag(){
        return this.tag;
    }
}

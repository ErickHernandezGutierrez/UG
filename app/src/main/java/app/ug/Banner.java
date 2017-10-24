package app.ug;

public class Banner {
    //Members
    private String name;
    private int imageID;

    //Constructors
    public Banner(){}
    public Banner(String name, int imageID){
        this.name = name;
        this.imageID = imageID;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setImageID(int imageID){
        this.imageID = imageID;
    }

    //Getters
    public String getName(){
        return this.name;
    }
    public int getImageID(){
        return this.imageID;
    }
}

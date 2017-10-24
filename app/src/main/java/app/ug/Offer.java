package app.ug;

public class Offer {
    //Members
    private String name;
    private String area;
    private String campus;

    //Constructors
    public Offer(){}
    public Offer(String name, String area, String campus){
        this.name = name;
        this.area = area;
        this.campus = campus;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setArea(String area){
        this.area = area;
    }
    public void setCampus(String campus){
        this.campus = campus;
    }

    //Getters
    public String getName(){
        return this.name;
    }
    public String getArea(){
        return this.area;
    }
    public String getCampus(){
        return this.campus;
    }
}

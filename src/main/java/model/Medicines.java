package model;

public class Medicines {
   private int id;
   private String name;
   private String type;
   private String company;
    private int cost;

   public  Medicines(int id,String name,String type,String company,int cost){
       this.id=id;
       this.name=name;
       this.type=type;
       this.company=company;
       this.cost=cost;
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    @Override
    public  String toString(){
       String text="";
       text+=id+","+name+","+type+","+company+","+cost;
       return  text;
    }

    @Override

    public  boolean equals(Object o){
       Medicines medicines=(Medicines)o;
       return medicines.name.equals(this.name);

    }
}

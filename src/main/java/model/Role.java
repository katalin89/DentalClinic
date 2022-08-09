package model;

public class Role {
    private  int id;
    private String title;
    private String description;

    public  Role(int id,String title,String description){
        this.id=id;
        this.title=title;
        this.description=description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public  String toString(){
        String text="";
        text+=id+","+title+"description";
        return  text;
    }

    @Override
    public boolean equals(Object o){
        Role role=(Role)o;
        return role.title.equals(this.title);
    }
}

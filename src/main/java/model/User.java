package model;

public class User
{
    private  int id;
    private int userRoleId;
    private String name;
    private String email;
    private  String dob;
    private String address;



    public  User(int id,int userRoleId,String name,String email,String dob,String address){
        this.id=id;
        this.userRoleId=userRoleId;
        this.name=name;
        this.email=email;
        this.dob=dob;
        this.address=address;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public  String toString(){
        String text="";
        text+=id+","+userRoleId+","+name+","+email+","+dob+","+address;
        return  text;

    }

    @Override
    public boolean equals(Object  o){
        User user=(User) o;
        return user.name.equals(this.name);
    }
}

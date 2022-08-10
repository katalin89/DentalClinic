package model;

public class Doctors  extends  User{
    private String mobile;
    private String password;
    private  String username;

    public Doctors(int id,String name,String email,String dob,String address,String mobile,String password,String username){
        super(id,2, name,email,dob,address);
        this.mobile=mobile;
        this.password=password;
        this.username=username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsename() {
        return username;
    }

    public void setUsename(String username) {
        this.username = username;
    }

    @Override

    public String toString(){
        String text=super.toString();
        text+=","+mobile+","+password+","+username;
        return text;
    }

    @Override
    public boolean equals(Object o){
        Doctors doctors=(Doctors) o;
        return doctors.username.equals(this.username);
    }
}

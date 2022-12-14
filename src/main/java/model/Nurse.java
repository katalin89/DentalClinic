package model;

import java.io.StringReader;

public class Nurse extends  User{
    private  String mobile;
    private String password;
    private String username;

    public Nurse(int id, int roleId, String name, String email, String dob, String address, String mobile, String password,String username){
        super(id,roleId,name,email,dob,address);
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public  String  toString(){
        String text=super.toString();
        text+=","+mobile+","+password+","+username;
        return text;

    }

    @Override
    public  boolean equals(Object o){
        Nurse nurse=(Nurse) o;
        return nurse.username.equals(this.username);
    }

}
/*

    @Override
    public boolean equals(Object  o){
        User user=(User) o;
        return user.name.equals(this.name);
    }
}
*/
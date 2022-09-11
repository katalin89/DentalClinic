package model;

import java.util.function.Predicate;

public class Permission {
    private int id;
    private int roleId;
    private String title;
    private String module;
    private String description;

    public Permission (int id,int roleId,String title,String module,String description){
        this.id=id;
        this.roleId=roleId;
        this.title=title;
        this.module=module;
        this.description=description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
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
        text+=id+","+roleId+","+title+","+module+","+description;
        return text;
    }
    @Override
    public boolean equals(Object o){
        Permission permission=(Permission) o;
        return permission.module.equals(this.module);
    }
}


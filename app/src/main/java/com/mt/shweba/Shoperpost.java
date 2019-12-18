package com.mt.shweba;

public class Shoperpost {
    private String type,price,name,location,codeno,stown;

    public Shoperpost(){

    }

    public String getStown() {
        return stown;
    }

    public void setStown(String stown) {
        this.stown = stown;
    }

    public String getType() {
        return type;
    }

    public String getCodeno() {
        return codeno;
    }

    public void setCodeno(String codeno) {
        this.codeno = codeno;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

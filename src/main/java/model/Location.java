package model;

import java.util.Objects;

public class Location {
    private double x; //Поле не может быть null
    private double y;
    private Long z; //Поле не может быть null
    private String name; //Поле может быть null
    public Location(Double x, double y, Long z, String name){
        this.x = Objects.requireNonNull(x, "Поле не может быть null");
        this.z = Objects.requireNonNull(z, "Поле не может быть null");
        this.name = Objects.requireNonNull(name, "Поле не может быть null");
        this.y = y;
    }

    public Location() {

    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public String getName(){
        return name;
    }
    public Long getZ(){
        return z;
    }
    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setZ(Long z) {
        this.z = z;
    }

    public void setName(String name) {
        this.name = name;
    }
}
package model;

import java.util.Objects;

public class Coordinates {
    private double x; //Максимальное значение поля: 89
    private Float y; //Поле не может быть null
    public Coordinates(double x, Float y){
        this.y = Objects.requireNonNull(y, "Значение поля не может быть null");
        if (x>89)
            throw new IllegalArgumentException("Значение аргумента не может быть более 89");
    }

    public Coordinates() {

    }

    public double getX(){
        return x;
    }
    public Float getY(){
        return y;
    }
    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Float y) {
        this.y = y;
    }
}

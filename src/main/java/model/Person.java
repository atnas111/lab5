package model;

import java.util.Objects;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.time.LocalDateTime birthday; //Поле не может быть null
    private int weight; //Значение поля должно быть больше 0
    private Location location; //Поле не может быть null
    public Person(String name, java.time.LocalDateTime birthday, int weight, Location location){
        this.name = Objects.requireNonNull(name, "Name не может быть null");
        if (name.isEmpty())
            throw new IllegalArgumentException("Имя не может быть пустым");
        this.birthday = Objects.requireNonNull(birthday, "birthday не может быть null");
        if (weight<=0)
            throw new IllegalArgumentException("Вес не может бвть меньше нуля");
        this.location = Objects.requireNonNull(location, "location не может быть null");
    }

    public Person() {

    }

    public String getName(){
        return name;
    }
    public java.time.LocalDateTime getBirthday(){
        return birthday;
    }
    public int getWeight(){
        return weight;
    }
    public Location getLocation(){
        return location;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(java.time.LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
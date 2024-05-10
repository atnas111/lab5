package model;

import java.util.Objects;

public class StudyGroup {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer studentsCount; //Значение поля должно быть больше 0, Поле может быть null
    private Double averageMark; //Значение поля должно быть больше 0, Поле не может быть null
    private FormOfEducation formOfEducation; //Поле может быть null
    private Semester semesterEnum; //Поле может быть null
    private Person groupAdmin; //Поле может быть null

    public StudyGroup(Long id, String name, Coordinates coordinates, java.time.LocalDateTime creationDate, Integer studentsCount,
                      Double averageMark, FormOfEducation formOfEducation, Semester semesterEnum, Person groupAdmin) {
        this.id = Objects.requireNonNull(id, "Значение поля не может быть null");
        this.name = Objects.requireNonNull(name, "Значение поля не может быть null");
        this.coordinates = Objects.requireNonNull(coordinates, "Значение поля не может быть null");
        this.creationDate = Objects.requireNonNull(creationDate, "Значение поля не может быть null");
        this.studentsCount = Objects.requireNonNull(studentsCount, "Значение поля не может быть null");
        this.averageMark = Objects.requireNonNull(averageMark, "Значение поля не может быть null");
        this.formOfEducation = Objects.requireNonNull(formOfEducation, "Значение поля не может быть null");
        this.semesterEnum = Objects.requireNonNull(semesterEnum, "Значение поля не может быть null");
        this.groupAdmin = Objects.requireNonNull(groupAdmin, "Значение поля не может быть null");
        if (id <= 0)
            throw new IllegalArgumentException("Значение id не может быть меньше нуля");
        if (name.isEmpty())
            throw new IllegalArgumentException("Имя не может быть пустым");
        if (studentsCount <= 0)
            throw new IllegalArgumentException("Значение studentsCount не может быть меньше нуля");
        if (averageMark <= 0)
            throw new IllegalArgumentException("Значение averageMark не может быть меньше нуля");

    }

    public StudyGroup() {

    }

    public Long getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public Coordinates getCoordinates(){
        return coordinates;
    }
    public java.time.LocalDateTime getCreationDate(){
        return creationDate;
    }
    public Integer getStudentsCount(){
        return studentsCount;
    }
    public Double getAverageMark(){
        return averageMark;
    }
    public FormOfEducation getFormOfEducation(){
        return formOfEducation;
    }
    public Semester getSemesterEnum(){
        return semesterEnum;
    }
    public Person getGroupAdmin(){
        return groupAdmin;
    }
    public String getGroupAdmname(){
        return groupAdmin.getName();
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(java.time.LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setStudentsCount(Integer studentsCount) {
        this.studentsCount = studentsCount;
    }

    public void setAverageMark(Double averageMark) {
        this.averageMark = averageMark;
    }

    public void setFormOfEducation(FormOfEducation formOfEducation) {
        this.formOfEducation = formOfEducation;
    }

    public void setSemesterEnum(Semester semesterEnum) {
        this.semesterEnum = semesterEnum;
    }

    public void setGroupAdmin(Person groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    public int compareTo(StudyGroup referenceStudyGroup) {
    return 1;}
}
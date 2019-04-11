package main.java;

public class Student {
    private String name;private String surname;private String fathersname;private String condition;
    Student(String name,String surname,String fathersname, String condition){
        this.name = name;
        this.surname  = surname;
        this.fathersname = fathersname;
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFathersname() {
        return fathersname;
    }

    public void setFathersname(String fathersname) {
        this.fathersname = fathersname;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "студент: " +
                "имя- " + name +
                ", фамилия- " + surname +
                ", отчество- " + fathersname +
                ", статус- " + condition ;
    }
}

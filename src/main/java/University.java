package main.java;

import java.util.ArrayList;
import java.util.List;


public class University {
    private String name; private List<Group> catalog;
    University (String name){
        this.name = name;
        this.catalog = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Университет: " +
                "название- " + name +
                ", cписок групп: " + catalog ;
    }

    public void generateGroupInfo(String path){
        for (int i = 0; i < catalog.size(); i++){

        }

    }

    public void add_group(Group i){
        this.catalog.add(i);
    }
}

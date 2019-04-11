package main.java;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Student s1 = new Student("john","black","grdrdb","st");
        Group g1 = new Group("0211","https://my.nsu.ru//public/resp/student-groups/group.xvm?ref=3620");
        University u1 = new University("nsu");
        u1.add_group(g1);
        System.out.println(u1);


    }

}

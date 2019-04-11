package main.java;

import java.util.ArrayList;

public class Main {

    private static final String NSU_URL = "https://my.nsu.ru//public/resp/student-groups/group.xvm?ref=6266";

    public static void main(String[] args) {
        Student s1 = new Student("john","black","grdrdb","st");
        Group g1 = new Group("0211",NSU_URL);
        University u1 = new University("nsu");
        u1.add_group(g1);
        u1.generateGroupInfo(NSU_URL);


    }

}

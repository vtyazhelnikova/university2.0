package main.java;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Student s1 = new Student("john","black","grdrdb","st");
        Group g1 = new Group("0211","https://my.nsu.ru//public/resp/student-groups/group.xvm?ref=6266");
        University u1 = new University("nsu");
        Group g2 = new Group("13212б","https://my.nsu.ru/public/resp/student-groups/group.xvm?ref=6267");
        u1.add_group(g2);
        u1.generateGroupInfo("C:\\Users\\leroc\\OneDrive\\Рабочий стол\\список групп");


    }

}

package main.java;

public class Main {

    public static void main(String[] args) {
        Student s1 = new Student("john","black","grdrdb","st");
        Group g1 = new Group("0211","https://my.nsu.ru//public/resp/student-groups/group.xvm?ref=6266");
        University u1 = new University("nsu");
        u1.add_group(g1);
        u1.add_group(new Group("16704","https://my.nsu.ru//public/resp/student-groups/group.xvm?ref=8980"));
        u1.generateGroupInfo("C:\\Users\\leroc\\OneDrive\\Рабочий стол\\список групп");


    }

}

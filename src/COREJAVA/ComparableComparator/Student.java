package COREJAVA.ComparableComparator;

import java.util.*;

public class Student implements Comparable<Student>{

    String name ;
    int marks ;

    public  Student(String name , int marks){
        this.marks=marks;
        this.name= name;
    }

    //ascending order
    @Override
    public int compareTo(Student s2 ){
        return this.marks-s2.marks;
    }


    // descending order
//    @Override
//    public int compareTo(Student s2 ){
//        if(this.marks==s2.marks) {
//            return this.name.length()-s2.name.length();
//        }
//        return s2.marks-this.marks;
//    }

    @Override
    public String toString(){
        return this.name+""+this.marks;
    }
    private int getMarks(Student t) {
        return t.marks;
    }

    public static void main(String[] args) {
        Student s1 = new Student("yashk",100);
        Student s3 = new Student("kskjdjj",345);
        Student s4 = new Student("nffl",435);
        Student s2 = new Student("abvkkks",122);
        Student s5 = new Student("kvpy",122);


//        System.out.println(s1.compareTo(s2));
        List<Student> list =  Arrays.asList(s1,s3,s4,s2,s5);


        // compartor will override comparable  using anonomoys class
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.name.length()-o2.name.length();
            }
        });

        // using lamda expression sorting in descending
        Collections.sort(list,(st1,st2)-> st2.name.length()-st1.name.length());

        Collections.sort(list,Comparator.comparingInt(st->st.marks));

        Collections.sort(list,Student::compareTo);

        System.out.println(list);

    }


}

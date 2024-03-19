import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        MyList<Student> list = new MyList<>();

        list.add(new Student(1, "Celline", "CE"));
        list.add(new Student(2, "James", "CE"));
        list.add(new Student(3, "Jason", "CE"));

        //list.sort();
        list.sort((Student s1, Student s2) -> s1.getName().compareTo(s2.getName()));
        //list.sort(new StudentNameComparator());

        for(Student i: list){
            System.out.println(i + " ");
        }


    }
}

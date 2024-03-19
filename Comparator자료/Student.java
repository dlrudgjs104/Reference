public class Student implements Comparable<Student>{
    private int studentNo;
    private String name;
    private String department;

    public Student(int studentNo, String name, String department){
        this.studentNo = studentNo;
        this.name = name;
        this.department = department;
    }

    public int compareTo(Student s){
        return this.studentNo - s.studentNo;
    }

    public String getName(){
        return this.name;
    }

    public String getDepartment(){
        return this.department;
    }

    @Override
    public String toString() {
        return "Student{studentNo=" + studentNo + ", name='" + name + "', department='" + department + "'}";
    }
    
}

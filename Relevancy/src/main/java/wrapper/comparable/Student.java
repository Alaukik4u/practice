package wrapper.comparable;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Student implements Comparable<Student> {
     public String name;
     public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public int compareTo(Student student) {
        if (this.age > student.age)
            return 1;
        else if (this.age == student.age)
            return 0;
        else
            return -1;
    }
}

class Test{
    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("sachin", 10));
        list.add(new Student("rachin", 5));

        list.sort(Student::compareTo);

        for(Student S : list){
            System.out.println(S);
        }
    }
}

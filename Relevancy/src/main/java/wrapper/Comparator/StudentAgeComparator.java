package wrapper.Comparator;

import lombok.Data;
import wrapper.comparable.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
public class StudentAgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.age > o2.age)
            return 1;
        else if (o1.age == o2.age)
            return 0;
        else
            return -1;    }
}

class Test{
    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("sachin", 10));
        list.add(new Student("rachin", 5));
        Collections.sort(list, new StudentAgeComparator());

        for(Student S : list){
            System.out.println(S);
        }
    }
}

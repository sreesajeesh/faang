import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class StudentMain {

    public static void main(String[] args) {
        Set<String> subjects = new HashSet<>();
        subjects.add("Maths");
        subjects.add("Science");
        subjects.add("English");
        List<Integer> marks1= new LinkedList<>();
        marks1.add(45);
        marks1.add(36);
        marks1.add(98);
        Student student1= new Student(1, "Payal", subjects, marks1);
//student1.getSubjects().add("History");
        subjects.add("History");
        System.out.println(student1);
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student implements Comparable<Student>{

    private int rollNumber;
    private String name;
    private Set<String> subjects;
    private List<Integer> marks ;

    public Student(int rollNumber, String name, Set<String> subjects,
                   List<Integer> marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.subjects = new HashSet<>(subjects);
        this.marks = new ArrayList<>(marks);
        setPercentage();
    }

    private float percentage;

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public Set<String> getSubjects() {
        return new HashSet<>(subjects);
    }

    public List<Integer> getMarks() {
        return new ArrayList<>(marks);
    }

    public float getPercentage() {
        return percentage;
    }

    private void setPercentage() {
        float sum = 0;

        for (Integer i : marks)
            sum = sum + i;
        if (!marks.isEmpty())
            percentage = sum / marks.size();

    }


    @Override
    public int compareTo(Student o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                ", subjects=" + subjects +
                ", marks=" + marks +
                ", percentage=" + percentage +
                '}';
    }
}



package sample1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentModel {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Ram", new Date("4/7/1999")));
        students.add(new Student(2, "Sam", new Date("8/10/1998")));
        students.add(new Student(3, "Lal", new Date("12/12/1997")));

        Map<Integer, String> studentMap = students.stream()
                .collect(Collectors.toMap(Student::getId, Student::getName));
        System.out.println(studentMap);
    }
}

/*
:there is a patient table in sql where it has fields like patientid, patientJoinDate.
write an sql query which will fetch all the patients records who are joined on the very recent day

select * from patient where patientJoinDate = (select patientJoinDate from patient order by desc limit 1)*/

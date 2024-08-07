package exclusive.streams;

import exclusive.data.Student;
import exclusive.data.StudentDataBase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class JavaStreamClasses {

    public static void main(String[] args) {

        //System.out.println(printStudentActivities());
        System.out.println(printUniqueStudentActivities());

        /*List<Integer> integerList = Arrays.asList(4,6,3,7);
        System.out.println(performMultiplication(integerList));
        System.out.println(performMultipleWithoutIdentity(integerList));*/
    }

    public static void oneOperationStream(){
        List<String> names = Arrays.asList("Sajeesh", "Ramesh", "Rakesh");
        Stream<String> nameStream = names.stream();
        nameStream.forEach(System.out::println);
        //nameStream.forEach(System.out::println);
    }

    //Flat Map example
    public static List<String> printStudentActivities(){
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public static Set<String> printUniqueStudentActivities(){
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .collect(Collectors.toCollection(TreeSet::new));
                /*.distinct()
                .sorted()
                .collect(Collectors.toList());*/
    }

    public static long   getNoOfActivities(){
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();
    }

    //reduce
    public static int performMultiplication(List<Integer> integerList){
        return integerList.stream()
                .reduce(1,(a,b)-> (a*b));
    }

    public static Optional<Integer> performMultipleWithoutIdentity(List<Integer> integerList){
        return integerList.stream()
                .reduce((a,b)-> (a*b));
    }

    public static String combineStudentNames(){
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .distinct()
                .reduce("", String::concat);
    }

    public static Optional<Student> getHighestGradeStudent(){
        return StudentDataBase.getAllStudents()
                .stream()
                .reduce((a,b)-> (a.getGpa()>b.getGpa())? a:b);
    }

    //Comparator examples
    public static List<Student> getStudentSortedByName(){
        return StudentDataBase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    public static List<Student> getStudentSortedByGPA(){
        return StudentDataBase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .collect(Collectors.toList());
    }

    public static List<Student> getStudentSortedByGPAReversed(){
        return StudentDataBase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(Collectors.toList());
    }

    //Stream Examples
    public static void streamExamples(){
        Predicate<Student> gradePredicate = student -> student.getGradeLevel()>=3;
        Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.9;

        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .filter(gpaPredicate)
                .collect(toMap(Student::getName, Student::getActivities));
    }

    //Filter Example
    public static List<Student> filterStudent(){
        return StudentDataBase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa()>=3.9)
                .filter(student -> student.getGender().equalsIgnoreCase("female"))
                .collect(Collectors.toList());
    }

    //Filter Map Reduce
    public static int noOfNotebooks(){
        return StudentDataBase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa() >=  3.9)
                .map(Student::getNoteBooks)
                .reduce(0, Integer::sum);
    }

    //Map example
    public static boolean getNameLength(){
        Map<String, Integer> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(toMap(String::toString, String::length));
        System.out.println(studentMap);
        return false;
    }
}

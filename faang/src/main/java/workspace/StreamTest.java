package workspace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamTest {

    public static void main(String[] args) throws IOException {
        List<Person> people = PeopleData.getPeople();
        //people.forEach(System.out::println);

        people.stream().mapToInt(Person::getAge)
                .average()
                .getAsDouble();

        people.sort(Comparator.comparing(Person::getFirstName));
    }
}

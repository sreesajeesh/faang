package java11;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {

    /**
     * A new static method {@link java.util.function.Predicate#not(Predicate)} has been added that supports creating a
     * Predicate that is the negation of a supplied Predicate. One of things this facilitates is using a method
     * reference when the right hand-side/body of the Lambda is a negated method invocation (on the single Lambda
     * param), which wasn't previously possible. See example below.
     */

    public static void main(String[] args) {
        testNot();
    }
    public static void testNot() {
        final String lyrics = "How long before I get in?\n" +
                "Before it starts, before I begin?\n" +
                "How long before you decide?\n" +
                "\n" +
                "Before I know what it feels like?\n";

        // Prior to Java 11, a Lambda function which negates the result of a method invocation on a single param could
        // NOT be reduced to a method reference, e.g.
        //lyrics.lines().filter((var s) -> !s.isBlank());

        // From J11, the new Predicate.not(Predicate) method allows a method reference to be used in the aforementioned
        // scenario -
        List<String> filteredLyrics = lyrics.lines()
                .filter(Predicate.not(String::isBlank)) // Apply Predicate.not(Predicate)
                .collect(Collectors.toList());
        System.out.println(filteredLyrics);

    }
}

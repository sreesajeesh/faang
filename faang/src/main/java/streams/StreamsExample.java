package streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {

    public static void main(String[] args) {
        //Stream be used only once for operation but can create multiple stream using Supplier
        List<String> strList = Arrays.asList("abc", "def", "ghi", " ", "jkl", "abc");
        Supplier<Stream<String>> supplier = strList::stream;
        List<String> nonEmptyStrings = supplier.get().filter(a -> !a.isBlank())
                .toList();
        System.out.println(nonEmptyStrings);
        Set<String> setStr = supplier.get()
                .filter(a-> !a.isBlank())
                .collect(Collectors.toSet());
        System.out.println(setStr);

        List<Integer> intList = Arrays.asList(2,4,7,9,5,8);
        IntSummaryStatistics summaryStatistics = intList.stream().mapToInt(p-> p)
                .summaryStatistics();
        System.out.println(summaryStatistics.getAverage());
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getCount());
    }
}
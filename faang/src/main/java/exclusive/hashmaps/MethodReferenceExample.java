package exclusive.hashmaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Bicycle {

    private String brand;
    private Integer frameSize;

    public Bicycle(String brand) {
        this.brand = brand;
        this.frameSize = 0;
    }

    // standard constructor, getters and setters

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getFrameSize() {
        return frameSize;
    }

    public void setFrameSize(Integer frameSize) {
        this.frameSize = frameSize;
    }
}

class BicycleComparator implements Comparator<Bicycle> {

    @Override
    public int compare(Bicycle a, Bicycle b) {
        return a.getFrameSize().compareTo(b.getFrameSize());
    }

}

public class MethodReferenceExample {

    public static void main(String[] args) {
        List<String> messages = Arrays.asList("hello", "baeldung", "readers!");
        BicycleComparator bikeFrameSizeComparator = new BicycleComparator();
        /*
        createBicyclesList().stream()
                .sorted((a, b) -> bikeFrameSizeComparator.compare(a, b));

         */

        /*
        createBicyclesList().stream()
                .sorted(bikeFrameSizeComparator::compare);

         */


        List<Integer> numbers = Arrays.asList(5, 3, 50, 24, 40, 2, 9, 18);
        numbers.stream()
                .sorted(Integer::compareTo);
        System.out.println(numbers.stream()
                .sorted()
                .collect(Collectors.toList())
        );
        // Reverse Sorting
        System.out.println(numbers.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList())
        );

        List<String> bikeBrands = Arrays.asList("Giant", "Scott", "Trek", "GT");

        Bicycle[] bicycles = bikeBrands.stream()
                .map(Bicycle::new)
                .toArray(Bicycle[]::new);

    }
}

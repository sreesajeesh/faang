package javaeight.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingDogs {

    public static void main(String[] args) {

        comparable(new Dog[]{new Dog("Spot", 2), new Dog("Rover", 7)});// just-in-time array
        comparable(Arrays.asList(new Dog("Spot", 2), new Dog("Rover", 7)));

        comparator(new Dog[]{new Dog("Rover", 7), new Dog("Spot", 2)});
        comparator(Arrays.asList(new Dog("Rover", 7), new Dog("Spot", 2)));

    }

    public static void comparable(Dog[] dogArray){
        Arrays.sort(dogArray);
        System.out.println(Arrays.toString(dogArray));
    }

    public static void comparable(List<Dog> dogList){
        Collections.sort(dogList);
        System.out.println(dogList);
    }

    public static void comparator(Dog[] dogArray){
        Comparator<Dog> byAge = Comparator.comparing(Dog::getAge);
        Arrays.sort(dogArray, byAge);
        System.out.println(Arrays.toString(dogArray));

        Comparator<Dog> byAgeReverse = Comparator.comparing(Dog::getAge, Comparator.reverseOrder());
        Arrays.sort(dogArray, byAgeReverse);
        System.out.println(Arrays.toString(dogArray));
    }

    public static void comparator(List<Dog> dogList){
        Comparator<Dog> byAge = Comparator.comparing(Dog::getAge);
        dogList.sort(byAge);
        System.out.println(dogList);

        Comparator<Dog> byAgeReverse = Comparator.comparing(Dog::getAge).reversed();
        dogList.sort(byAgeReverse);
        System.out.println(dogList);
    }
}

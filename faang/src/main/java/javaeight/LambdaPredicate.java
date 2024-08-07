package javaeight;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaPredicate {

    public static void main(String[] args) {
        Evaluate<Integer> evaluate = i -> {return i < 0;};
        System.out.println(evaluate.isNegative(-1));
        System.out.println(evaluate.isNegative(1));

        Predicate<Integer> predicate = i -> i < 0;
        System.out.println(predicate.test(-1));
        System.out.println(predicate.test(1));

        int x = 4;
        System.out.println(check(x, n-> n%2 == 0));

        BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
        System.out.println(checkLength.test("Hello", 5));
        System.out.println(checkLength.test("Hi", 5));

        Supplier<StringBuilder> supSB = StringBuilder::new;
        System.out.println(supSB.get().append("SK"));

        Supplier<LocalTime> supTime = LocalTime::now;
        System.out.println(supTime.get());

        Supplier<Double> supDb = Math::random;
        System.out.println(supDb.get());

        Consumer<String> printC = System.out::println;
        printC.accept("Sajeesh");

        List<String> strList = new ArrayList<>();
        strList.add("Sajeesh");
        strList.add("Anuradha");
        strList.add("Srinivas");
        strList.add("Gambir");

        strList.forEach(printC);

        Map<String, String> mapCapitalCities = new HashMap<>();
        BiConsumer<String,String> biCon = mapCapitalCities::put;
        biCon.accept("Chennai", "TamilNadu");
        biCon.accept("Trivandrum", "Kerala");
        System.out.println(mapCapitalCities);

        BiConsumer<String, String> mapPrint = (key, value) -> System.out.println(key + " is capital of " + value);
        mapCapitalCities.forEach(mapPrint);
        Function<String, Integer> strLength = String::length;
        System.out.println(strLength.apply("Sajeesh Kumar"));

        BiFunction<String, String, Integer> bifn1 = (s1, s2) -> s1.length() + s2.length();
        BiFunction<String, String, String> bifn2 = String::concat;

        System.out.println(bifn1.apply("Sajeesh", "Kumar"));
        System.out.println(bifn2.apply("Sajeesh", "Kumar"));

        UnaryOperator<String> unaryOp = name -> "My name is " + name;
        System.out.println(unaryOp.apply("Sajeesh Kumar"));

        BinaryOperator<String> binOp = String::concat;
        System.out.println(binOp.apply("Sajeesh", "Kumar"));
    }

    public static <T> boolean check(T t, Predicate<T> lambda){
        return lambda.test(t);
    }
}

interface Evaluate<T> {
    boolean isNegative(T t);
}

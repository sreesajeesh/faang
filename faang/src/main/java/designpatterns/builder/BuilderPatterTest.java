package designpatterns.builder;

public class BuilderPatterTest {

    public static void main(String[] args) {
        ClaimCalculator cc = new ClaimCalculator
                .ClaimSBuilder("A123", "C124", "01/05/2024", "1000")
                .setAge("28")
                .setLimits("NO_LIMIT")
                .build();

        ClaimCalculator cc2 = new ClaimCalculator
                .ClaimSBuilder("B123", "C222", "01/05/2024", "1500")
                .setAge("32")
                .setAddress("Pune")
                .setLocation("India")
                .build();

        System.out.println(cc);
        System.out.println();
        System.out.println(cc2);
    }
}

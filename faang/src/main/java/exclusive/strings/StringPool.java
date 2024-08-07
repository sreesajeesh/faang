package exclusive.strings;

public class StringPool {

    public static void main(String[] args) {
        String str = "Hello World";
        String str1 = "Hello World";

        String strObj = new String("Hello World");
        String strObj1 = new String("Hello World");

        System.out.println(str == str1);
        System.out.println(str.equals(str1));

        System.out.println(strObj == strObj1);
        System.out.println(strObj.equals(strObj1));

        concat1(strObj);

        System.out.println(strObj);

/*        Employee emp1 = new Employee(1, "Sajeesh", "Kumar");
        Employee emp2 = new Employee(2, "Sathish", "Kumar");
        Employee emp3 = new Employee(1, "Sajeesh", "Kumar");

        System.out.println(emp1 == emp3);
        System.out.println(emp1.equals(emp3));
        System.out.println(emp1.hashCode());
        System.out.println(emp3.hashCode());*/
    }

    public static void concat1(String s1)
    {
        s1 = new String(s1 + "forgeeks");
    }
}

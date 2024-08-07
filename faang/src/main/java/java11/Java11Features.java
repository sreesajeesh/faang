package java11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Java11Features {

    public static void main(String[] args) {
        // Launching single file program without compilation
        // Local Variable (var) syntax for Lambda parameters
        //Additional String utility methods
        // 1. repeat() 2. lines(), 3. isBlank(), 4. stripLeading(), 5. stripTrailing 6. strip()
        // toArray function to convert the list to array of datatype
        // Optional.isEmpty()
        // TimeUnit conversion
        // FileStream 1. writeString 2. readString 3. isSameFile

        Map<String, String> mapStr = new HashMap<>();
        mapStr.put("R", "Ram");
        mapStr.put("S", "Sam");

        String[] str = mapStr.keySet().toArray(String[]::new);
        String[] valueStr = mapStr.values().toArray(new String[0]);
//        System.out.println(Arrays.toString(str));
//        System.out.println(Arrays.toString(valueStr));

        //Difference between trim() and strip()
        String s = "\t abc \n";

//        System.out.println(("abc").equals(s.trim()));
//        System.out.println(("abc").equals(s.strip()));

        Character c = '\u2000';
        s = c + "abc" + c;
//        System.out.println(c);
//        System.out.println(("abc").equals(s.trim()));
//        System.out.println(("abc").equals(s.strip()));

        String string = '\u2001'+"String    with    space"+ '\u2001';
        System.out.println("Before: \"" + string+"\"");
        System.out.println("After trim: \"" + string.trim()+"\"");
        System.out.println("After strip: \"" + string.strip()+"\"");
    }
}

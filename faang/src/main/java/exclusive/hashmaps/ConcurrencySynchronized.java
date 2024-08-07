package exclusive.hashmaps;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrencySynchronized {

    public static void main(String[] args) {
        Map<Integer, String> shm = Collections.synchronizedMap(new HashMap<>());
        try {
            shm.put(null, null);
        } catch (Exception e){
            System.out.println("Error in Synchronized Hash Map");
        }

        ConcurrentHashMap<Integer, String> chm = new ConcurrentHashMap<>();
        try {
            chm.put(null, null);
        } catch (Exception e){
            System.out.println("Error in Concurrent Hash Map");
        }
    }
}

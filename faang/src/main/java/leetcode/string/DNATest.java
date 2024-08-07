package leetcode.string;

import java.util.HashMap;
import java.util.stream.Collectors;

public class DNATest {

    public static void main(String[] args) {
        HashMap<String, Integer> dnamap = getDNA("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(dnamap.entrySet().stream()
                .filter(map -> map.getValue() > 1)
                .collect(Collectors.toList()));
    }

    public static HashMap<String , Integer> getDNA(String dnaStr){
        HashMap<String, Integer> dnaMap = new HashMap<>();
        for(int i = 0; i < dnaStr.length()-10; i++){
            String str = dnaStr.substring(i, i+10);
            dnaMap.put(str, dnaMap.getOrDefault(str, 0) + 1);
        }
        return dnaMap;
    }
}

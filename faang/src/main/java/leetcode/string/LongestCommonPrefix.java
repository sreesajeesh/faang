package leetcode.string;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] str = new String[]{"flower", "flow", "flight"};
        System.out.println(getCommon(str));
    }

    public static String getCommonPrefix(String[] list){
        String firstElement = list[0];
        String nextElement;
        for(int i = 1; i < list.length; i++){
            if(firstElement.length() < list[i].length()){
                nextElement = list[i].substring(0, firstElement.length());
            } else{
                nextElement = list[i];
                firstElement = firstElement.substring(0, list[i].length());
            }
            while (!firstElement.equals(nextElement)){
                firstElement = firstElement.substring(0, firstElement.length() -1);
                nextElement = nextElement.substring(0, nextElement.length() - 1);
            }
        }
        return firstElement;
    }

    public static String getCommon(String[] strs){
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            while (strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}

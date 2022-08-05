package utils;

public class StringToArray {
    public static int[][] stringToArray(String array) {
        String[] strings = array.split("],");
        int[][] result = new int[strings.length][0];
        for (int j = 0; j < strings.length; j ++) {
            String[] s = strings[j].replaceAll("\\[", "").replaceAll("]", "").replaceAll(" ", "").split(",");
            int[] tmp = new int[s.length];
            for (int i = 0; i < s.length; i ++) {
                tmp[i] = Integer.parseInt(s[i]);
            }
            result[j] = tmp;
        }
        return result;
    }
}

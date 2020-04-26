package util;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static String array2str(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length-1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public static List<Integer> array2list(int[] array) {
        List<Integer> res = new ArrayList<>();
        for (int value : array) {
            res.add(value);
        }
        return res;
    }

    public static List<List<Integer>> array2d2list(int[][] array) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] ints : array) {
            res.add(array2list(ints));
        }
        return res;
    }
}

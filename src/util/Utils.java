package util;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static ArrayList<Boolean> array2list(boolean[] data) {
        ArrayList<Boolean> res = new ArrayList<>(data.length);
        for (int i = 0; i < data.length; i++) {
            res.add(data[i]);
        }
        return res;
    }

    public static <T> List<T> array2List(T[] data) {
        ArrayList<T> res = new ArrayList<>(data.length);
        for (int i = 0; i < data.length; i++) {
            res.add(data[i]);
        }
        return res;
    }

    public static <T> List<List<T>> array2d2list(T[][] array) {
        List<List<T>> res = new ArrayList<>();
        for (T[] ints : array) {
            res.add(array2List(ints));
        }
        return res;
    }

    public static String array2str(String[] array) {
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

    public static String arrdy2d2str(int[][] array) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int r = 0; r < array.length; r++) {
            sb.append(array2str(array[r]));
            if (r != array.length-1) {
                sb.append(',');
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

    // [[], [], []]
    public static int[][] str2array2d(String array) {
        int len = 0;
        List<int[]> res = new ArrayList<>();

        String[] arr = array.trim().substring(1, array.length()-1).split("],");
        for (String a : arr) {
            if (a.isBlank()) {
                continue;
            }
            a = a.trim();
            if (a.endsWith("]")) {
                a = a.substring(0, a.length()-1);
            }
            a = a.trim();
            String[] d = a.substring(1).split(",");
            int[] line = new int[d.length];
            for (int i = 0; i < d.length; i++) {
                line[i] = Integer.parseInt(d[i].trim());
            }
            res.add(line);
        }

        int[][] r = new int[res.size()][len];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}

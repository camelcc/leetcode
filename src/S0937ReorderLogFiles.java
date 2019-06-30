import java.util.Arrays;

public class S0937ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Integer[] indices = new Integer[logs.length];
        for (int i = 0; i < logs.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (Integer i1, Integer i2) -> {
            String o1 = logs[i1];
            int s1 = o1.indexOf(' ');
            String log1 = o1.substring(s1+1);
            String o2 = logs[i2];
            int s2 = o2.indexOf(' ');
            String log2 = o2.substring(s2+1);
            if (Character.isDigit(log1.charAt(0)) &&
                    Character.isDigit(log2.charAt(0))) {
                return i1-i2;
            } else if (Character.isDigit(log1.charAt(0))) {
                return 1;
            } else if (Character.isDigit(log2.charAt(0))) {
                return -1;
            } else {
                if (log1.equals(log2)) {
                    return o1.compareTo(o2);
                } else {
                    return log1.compareTo(log2);
                }
            }
        });
        String[] res = new String[logs.length];
        for (int i = 0; i < indices.length; i++) {
            res[i] = logs[indices[i]];
        }
        return res;
    }
}

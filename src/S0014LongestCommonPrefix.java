public class S0014LongestCommonPrefix {
    // MSD
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String smallest = strs[0];
        String largest = strs[0];
        for (String str : strs) {
            if (smallest.compareTo(str) > 0) {
                smallest = str;
            }
            if (largest.compareTo(str) < 0) {
                largest = str;
            }
        }

        int i = 0;
        for (i = 0; i < Math.min(smallest.length(), largest.length()); i++) {
            if (smallest.charAt(i) != largest.charAt(i)) {
                break;
            }
        }
        return smallest.substring(0, i);
    }
}

public class S0014LongestCommonPrefix {
    // MSD
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        StringBuilder prefix = new StringBuilder();
        int index = 0;
        char c;
        boolean allEqual;
        do {
            c = index >= strs[0].length() ? '\0' : strs[0].charAt(index);
            allEqual = true;
            for (int i = 1; i < strs.length; i++) {
                if ((index >= strs[i].length() ? '\0' : strs[i].charAt(index)) != c) {
                    allEqual = false;
                    break;
                }
            }
            if (allEqual) {
                if (c != '\0') {
                    prefix.append(c);
                }
                index++;
            }
        } while (allEqual && c != '\0');
        return prefix.toString();
    }
}

public class S1946LargestNumberAfterMutatingSubstring {
    public String maximumNumber(String num, int[] change) {
        StringBuilder sb = new StringBuilder();
        int mutate = 0; // 0 - not mutate, 1 - mutating, 2 - mutated
        for (char c : num.toCharArray()) {
            if (mutate == 2) {
                sb.append(c);
                continue;
            }
            // mutate == 0 || mutate == 1
            int v = c-'0';
            if (change[v] > v) {
                sb.append((char)(change[v]+'0'));
                mutate = 1;
            } else if (change[v] == v) {
                sb.append(c);
            } else {
                sb.append(c);
                if (mutate == 1) {
                    mutate = 2;
                }
            }
        }
        return sb.toString();
    }
}

public class S1689PartitioningMinimumNumberDeciBinaryNumbers {
    public int minPartitions(String n) {
        int res = 0;
        while (!n.isEmpty()) {
            n = reduce(n);
            res++;
        }
        return res;
    }

    private String reduce(String n) {
        StringBuilder sb = new StringBuilder();
        for (char c : n.toCharArray()) {
            char nc = c == '0' ? '0' : (char)(c-1);
            if (sb.length() != 0) {
                sb.append(nc);
            } else {
                if (nc != '0') {
                    sb.append(nc);
                }
            }
        }
        return sb.toString();
    }
}

import java.util.HashMap;

public class S2217FindPalindromeWithFixedLength {
    public long[] kthPalindrome(int[] queries, int intLength) {
        HashMap<Integer, Integer> cnt = new HashMap();
        cnt.put(0, 1);
        int c = 1;
        for (int i = 1; i < 17; i+=2) {
            c = c * 10;
            cnt.put(i, c);
            cnt.put(i+1, c);
        }

        long[] res = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = palindrome(queries[i], intLength, cnt);
        }
        return res;
    }

    private long palindrome(int query, int len, HashMap<Integer, Integer> cnt) {
        if (len <= 2) {
            return Long.parseLong(small(len, query));
        }
        // len > 2
        int cap = cnt.get(len) - cnt.get(len-2);
        if (query > cap) {
            return -1;
        }
        query += cnt.get(len-2) - 1;
        String res = query(len, query, cnt);
        return Long.parseLong(res);
    }

    private String query(int len, int query, HashMap<Integer, Integer> cnt) {
        if (len <= 2) {
            return small(len, query);
        }
        StringBuilder res = new StringBuilder();
        int l = cnt.get(len-2);
        int d = query/l;
        int r = query%l;
        res.append((char)('0'+d));
        res.append(query(len-2, r, cnt));
        res.append((char)('0'+d));
        return res.toString();
    }

    private String small(int len, int query) {
        if (query >= 10) {
            return "-1";
        }
        // len <= 2
        if (len == 1) {
            return String.valueOf(query);
        } else if (len == 2) {
            return query + String.valueOf(query);
        }
        return "-1";
    }
}

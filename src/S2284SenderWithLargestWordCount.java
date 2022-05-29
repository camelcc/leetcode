import java.util.HashMap;

public class S2284SenderWithLargestWordCount {
    public String largestWordCount(String[] messages, String[] senders) {
        String res = senders[0];
        int max = 0;
        HashMap<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            String s = senders[i];
            int len = messages[i].split(" ").length;
            cnt.put(s, cnt.getOrDefault(s, 0)+len);
            if (cnt.get(s) >= max) {
                if (cnt.get(s) > max || s.compareTo(res) > 0) {
                    res = s;
                }
                max = cnt.get(s);
            }
        }
        return res;
    }
}

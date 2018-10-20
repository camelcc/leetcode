import java.util.HashSet;

public class S0884UncommonWordsTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        HashSet<String> res = new HashSet<>();
        HashSet<String> dup = new HashSet<>();
        for (String s : A.split(" ")) {
            if (s.isEmpty() || s.equals(" ") || dup.contains(s)) {
                continue;
            }
            if (res.contains(s)) {
                dup.add(s);
                res.remove(s);
            } else {
                res.add(s);
            }
        }
        for (String s : B.split(" ")) {
            if (s.isEmpty() || s.equals(" ") || dup.contains(s)) {
                continue;
            }
            if (res.contains(s)) {
                dup.add(s);
                res.remove(s);
            } else {
                res.add(s);
            }
        }
        return res.toArray(new String[0]);
    }
}

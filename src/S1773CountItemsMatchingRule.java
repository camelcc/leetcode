import java.util.List;

public class S1773CountItemsMatchingRule {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        int i = 0;
        if (ruleKey.equals("type")) {
            i = 0;
        } else if (ruleKey.equals("color")) {
            i = 1;
        } else if (ruleKey.equals("name")) {
            i = 2;
        }
        for (List<String> item : items) {
            if (item.get(i).equals(ruleValue)) {
                res++;
            }
        }
        return res;
    }
}

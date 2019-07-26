import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S1125SmallestSufficientTeam {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        HashMap<String, Integer> skills = new HashMap<>();
        for (int i = 0; i < req_skills.length; i++) {
            skills.put(req_skills[i], i);
        }
        int[] p = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            List<String> ps = people.get(i);
            int v = 0;
            for (String s : ps) {
                v |= (0x1<<skills.get(s));
            }
            p[i] = v;
        }
        int target = (0x1<<req_skills.length)-1;

        List<Integer> res = team(p, target, 0, new HashMap<>());
        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }

    private List<Integer> team(int[] people, int target, int current,
                               HashMap<Integer, List<Integer>> dp) {
        if (dp.containsKey(current)) {
            return dp.get(current);
        }
        assert current != target;
        List<Integer> min = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            min.add(i);
        }
        for (int i = 0; i < people.length; i++) {
            int next = current | people[i];
            if (next == current) {
                continue;
            } else if (next == target) {
                min = new ArrayList<>();
                min.add(i);
                break;
            } else {
                // next != current && next != target
                List<Integer> t = new ArrayList<>(team(people, target, next, dp));
                t.add(i);
                if (min.size() > t.size()) {
                    min = t;
                }
            }
        }
        dp.put(current, min);
        return min;
    }
}

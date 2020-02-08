import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class S0433MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        List<String[]> mutations = new ArrayList<>();
        mutations.add(new String[]{start, String.valueOf(0)});
        HashSet<String> visited = new HashSet<>();
        visited.add(start);

        while (!mutations.isEmpty()) {
            String[] m = mutations.remove(0);
            String gene = m[0];
            int steps = Integer.valueOf(m[1]);
            assert !gene.equals(end);

            for (String mutes : mutations(gene, bank)) {
                if (end.equals(mutes)) {
                    return steps + 1;
                }
                if (!visited.contains(mutes)) {
                    mutations.add(new String[]{mutes, String.valueOf(steps+1)});
                }
            }
            visited.add(gene);
        }

        return -1;
    }

    private List<String> mutations(String gene, String[] bank) {
        List<String> res = new ArrayList<>();

        for (String b : bank) {
            if (validMutation(gene, b)) {
                res.add(b);
            }
        }
        return res;
    }

    private boolean validMutation(String gene, String mutation) {
        assert gene != null && mutation != null;
        if (gene.equals(mutation)) {
            return false;
        }
        if (gene.length() != mutation.length()) {
            return false;
        }

        int diff = 0;
        for (int i = 0; i < gene.length(); i++) {
            if (gene.charAt(i) != mutation.charAt(i)) {
                diff++;
            }
            if (diff >= 2) {
                return false;
            }
        }
        return true;
    }
}

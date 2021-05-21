import java.util.HashSet;

public class S1733MinimumNumberPeopleTeach {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        boolean[] users = new boolean[languages.length+1];
        for (int[] f : friendships) {
            HashSet<Integer> l1 = new HashSet<>();
            for (int l : languages[f[0]-1]) {
                l1.add(l);
            }
            boolean matched = false;
            for (int l : languages[f[1]-1]) {
                if (l1.contains(l)) {
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                users[f[0]] = true;
                users[f[1]] = true;
            }
        }

        HashSet<Integer>[] lang = new HashSet[n+1];
        for (int i = 0; i < lang.length; i++) {
            lang[i] = new HashSet<>();
        }
        for (int i = 0; i < languages.length; i++) {
            if (!users[i+1]) {
                continue;
            }
            for (int l : languages[i]) {
                lang[l].add(i+1);
            }
        }

        int total = 0;
        for (int i = 1; i < languages.length+1; i++) {
            if (users[i]) {
                total++;
            }
        }
        int res = languages.length;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, total-lang[i].size());
        }
        return res;
    }
}

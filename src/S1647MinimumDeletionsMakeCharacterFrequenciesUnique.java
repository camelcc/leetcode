import java.util.Arrays;

public class S1647MinimumDeletionsMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c-'a']++;
        }
        Arrays.sort(cnt);
        int pre = cnt[cnt.length-1];
        int i = cnt.length-2;
        int res = 0;
        while (i >= 0 && cnt[i] > 0) {
            if (cnt[i] < pre) {
                pre = cnt[i];
                i--;
                continue;
            }

            // cnt[i] == pre
            res++;
            int j = i;
            while (j >= 0 && cnt[j] == cnt[i]) {
                j--;
            }
            j++;
            cnt[j]--;
        }
        return res;
    }
}

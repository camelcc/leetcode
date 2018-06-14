public class S0455AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        selectSort(g);
        selectSort(s);

        int res = 0;
        int cookieIndex = 0;
        int childIndex = 0;
        while (cookieIndex < s.length && childIndex < g.length) {
            if (s[cookieIndex] < g[childIndex]) {
                childIndex++;
                continue;
            }
            cookieIndex++;
            childIndex++;
            res++;
        }
        return res;
    }

    private void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int maxIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[maxIndex] < array[j]) {
                    maxIndex = j;
                }
            }
            if (i != maxIndex) {
                int t = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = t;
            }
        }
    }
}

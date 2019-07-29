public class S1138AlphabetBoardPath {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        char prev = 'a';
        for (char c : target.toCharArray()) {
            sb.append(path(prev, c)).append('!');
            prev = c;
        }
        return sb.toString();
    }

    private String path(char a, char b) {
        int[][] POS = new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4},
                {1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4},
                {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4},
                {3, 0}, {3, 1}, {3, 2}, {3, 3}, {3, 4},
                {4, 0}, {4, 1}, {4, 2}, {4, 3}, {4, 4},
                {5, 0}};
        if (a == b) {
            return "";
        }
        if (a == 'z') {
            return "U"+path('u', b);
        } else if (b == 'z') {
            return path(a, 'u')+"D";
        } else {
            StringBuilder sb = new StringBuilder();
            int[] src = POS[a-'a'], dst = POS[b-'a'];
            while (src[0] != dst[0]) {
                if (src[0] < dst[0]) {
                    sb.append("D");
                    src[0]++;
                } else if (src[0] > dst[0]) {
                    sb.append("U");
                    src[0]--;
                }
            }
            assert src[0] == dst[0];
            while (src[1] != dst[1]) {
                if (src[1] < dst[1]) {
                    sb.append("R");
                    src[1]++;
                } else if (src[1] > dst[1]) {
                    sb.append("L");
                    src[1]--;
                }
            }
            return sb.toString();
        }
    }
}

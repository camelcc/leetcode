public class S0838PushDominoes {
    public String pushDominoes(String dominoes) {
        if (dominoes.length() <= 1 || !dominoes.contains(".")) {
            return dominoes;
        }
        char[] original = dominoes.toCharArray();

        char[] d = dominoes.toCharArray();
        for (int i = 0; i < d.length; i++) {
            if (d[i] != '.') {
                continue;
            }

            if (i == 0) {
                if (original[i+1] == 'L') {
                    d[i] = 'L';
                }
            } else if (i == d.length-1) {
                if (original[i-1] == 'R') {
                    d[i] = 'R';
                }
            } else {
                if (original[i-1] == 'R' && original[i+1] == '.') {
                    d[i] = 'R';
                } else if ((original[i-1] == '.' || original[i-1] == 'L') && original[i+1] == 'L') {
                    d[i] = 'L';
                } else if (original[i-1] == 'R' && original[i+1] == 'R') {
                    d[i] = 'R';
                }
            }
        }

        if (dominoes.equals(new String(d))) {
            return dominoes;
        } else {
            return pushDominoes(new String(d));
        }
    }
}

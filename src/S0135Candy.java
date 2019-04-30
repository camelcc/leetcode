public class S0135Candy {
    public int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }

        int[] v = new int[ratings.length];
        v[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] < ratings[i-1]) {
                if (v[i-1] == 1) {
                    v[i] = 1;
                    int p = i-1;
                    while (p >= 0) {
                        if (ratings[p] < ratings[p+1]) {
                            assert v[p] < v[p+1];
                            break;
                        } else if (ratings[p] == ratings[p+1]) {
                            break;
                        } else {
                            if (v[p] <= v[p+1]) {
                                v[p] = v[p+1]+1;
                            }
                        }
                        p--;
                    }
                } else {
                    v[i] = 1;
                }
            } else if (ratings[i] == ratings[i-1]) {
                v[i] = 1;
            } else {
                v[i] = v[i-1]+1;
            }
        }

        int res = 0;
        for (int i = 0; i < v.length; i++) {
            res += v[i];
        }
        return res;
    }
}

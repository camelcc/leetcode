public class S1363LargestMultipleThree {
    public String largestMultipleOfThree(int[] digits) {
        int[] cnt = new int[10];
        int sum = 0;
        for (int d : digits) {
            cnt[d]++;
            sum += d;
        }
        if (sum%3 == 2) {
            if (cnt[2] > 0) {
                cnt[2]--;
            } else if (cnt[5] > 0) {
                cnt[5]--;
            } else if (cnt[8] > 0) {
                cnt[8]--;
            } else {
                // first time
                if (cnt[1] > 0) {
                    cnt[1]--;
                } else if (cnt[4] > 0) {
                    cnt[4]--;
                } else if (cnt[7] > 0) {
                    cnt[7]--;
                } else {
                    return "";
                }
                // second time
                if (cnt[1] > 0) {
                    cnt[1]--;
                } else if (cnt[4] > 0) {
                    cnt[4]--;
                } else if (cnt[7] > 0) {
                    cnt[7]--;
                } else {
                    return "";
                }
            }
        } else if (sum%3 == 1) {
            if (cnt[1] > 0) {
                cnt[1]--;
            } else if (cnt[4] > 0) {
                cnt[4]--;
            } else if (cnt[7] > 0) {
                cnt[7]--;
            } else {
                // first time
                if (cnt[2] > 0) {
                    cnt[2]--;
                } else if (cnt[5] > 0) {
                    cnt[5]--;
                } else if (cnt[8] > 0) {
                    cnt[8]--;
                } else {
                    return "";
                }
                // second time
                if (cnt[2] > 0) {
                    cnt[2]--;
                } else if (cnt[5] > 0) {
                    cnt[5]--;
                } else if (cnt[8] > 0) {
                    cnt[8]--;
                } else {
                    return "";
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (cnt[i] > 0) {
                sb.append(i);
                cnt[i]--;
            }
        }
        String res = sb.toString();
        if (res.isEmpty()) {
            return "";
        }

        if (res.startsWith("0")) {
            return "0";
        }
        return res;
    }
}

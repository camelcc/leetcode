public class S0488ZumaGame {
    public int findMinStep(String board, String hand) {
        if (board.isEmpty()) {
            return 0;
        }
        if (hand.isEmpty()) {
            return -1;
        }

        int res = -1;
        for (int i = 0; i < board.length(); i++) {
            char c = board.charAt(i);
            int ci = hand.indexOf(c);
            if (ci == -1) {
                continue;
            }
            if (i != 0 && board.charAt(i) == board.charAt(i-1)) {
                continue;
            }
            StringBuilder balls = new StringBuilder(hand);
            balls.deleteCharAt(ci);

            StringBuilder sb = new StringBuilder(board);
            int t = -1;
            if (i == board.length()-1 || board.charAt(i) != board.charAt(i+1)) {
                sb.insert(i, board.charAt(i));
                t = findMinStep(sb.toString(), balls.toString());
            } else {
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
                if (sb.length() > 0) {
                    t = findMinStep(merge(sb.toString()), balls.toString());
                } else {
                    t = 0;
                }
            }
            if (t != -1) {
                if (res == -1) {
                    res = t+1;
                } else {
                    res = Math.min(res, t+1);
                }
            }
        }

        return res;
    }

    private String merge(String board) {
        assert !board.isEmpty();
        StringBuilder sb = new StringBuilder();
        char current = board.charAt(0);
        int cnt = 1;
        for (int i = 1; i < board.length(); i++) {
            char c = board.charAt(i);
            if (c != current) {
                if (cnt == 1) {
                    sb.append(current);
                } else if (cnt == 2) {
                    sb.append(current);
                    sb.append(current);
                } else {
                    sb.append(board.substring(i));
                    return merge(sb.toString());
                }
                current = c;
                cnt = 1;
            } else {
                cnt++;
            }
        }
        if (cnt == 1) {
            sb.append(current);
        } else if (cnt == 2) {
            sb.append(current);
            sb.append(current);
        } else {
            if (sb.length() > 0) {
                return merge(sb.toString());
            } else {
                return "";
            }
        }
        return sb.toString();
    }
}

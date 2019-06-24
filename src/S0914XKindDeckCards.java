import java.util.Arrays;

public class S0914XKindDeckCards {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 1) {
            return false;
        }
        Arrays.sort(deck);
        int gcd = -1;
        int cnt = 1;
        for (int i = 1; i < deck.length; i++) {
            if (deck[i] == deck[i-1]) {
                cnt++;
            } else {
                if (cnt == 1) {
                    return false;
                }
                if (gcd == -1) {
                    gcd = cnt;
                } else {
                    gcd = gcd(gcd, cnt);
                    if (gcd == 1) {
                        return false;
                    }
                }
                cnt = 1;
            }
        }
        if (gcd == -1) {
            return true;
        }
        if (cnt == 1) {
            return false;
        }
        if (gcd(gcd, cnt) == 1) {
            return false;
        }
        return true;
    }

    private int gcd(int a, int b) {
        if (a%b == 0) {
            return b;
        }
        return gcd(b, a%b);
    }
}

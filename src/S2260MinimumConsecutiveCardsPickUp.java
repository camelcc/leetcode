import java.util.HashMap;

public class S2260MinimumConsecutiveCardsPickUp {
    public int minimumCardPickup(int[] cards) {
        int res = cards.length+1;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < cards.length; i++) {
            int c = cards[i];
            if (map.containsKey(c)) {
                int r = i - map.get(c) + 1;
                res = Math.min(res, r);
            }
            map.put(c, i);
        }
        return res == cards.length+1 ? -1 : res;
    }
}

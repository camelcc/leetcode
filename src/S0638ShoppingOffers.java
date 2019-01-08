import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S0638ShoppingOffers {
    private HashMap<List<Integer>, Integer> prices = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (prices.containsKey(needs)) {
            return prices.get(needs);
        }

        int res = Integer.MAX_VALUE;
        for (List<Integer> s : special) {
            List<Integer> n = purchaseSpecial(s, needs);
            if (n == null) {
                continue;
            }

            int r = s.get(s.size()-1) + shoppingOffers(price, special, n);
            if (res > r) {
                res = r;
            }
        }
        // base
        int base = 0;
        for (int i = 0; i < needs.size(); i++) {
            base += price.get(i)*needs.get(i);
        }
        if (res > base) {
            res = base;
        }

        prices.put(needs, res);
        return res;
    }

    private List<Integer> purchaseSpecial(List<Integer> special, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            if (special.get(i) > needs.get(i)) {
                return null;
            }
        }
        List<Integer> res = new ArrayList<>(needs.size());
        for (int i = 0; i < needs.size(); i++) {
            res.add(needs.get(i) - special.get(i));
        }
        return res;
    }
}

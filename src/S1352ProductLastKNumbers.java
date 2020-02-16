import java.util.ArrayList;
import java.util.List;

public class S1352ProductLastKNumbers {
    public static class ProductOfNumbers {
        List<Long> products;

        public ProductOfNumbers() {
            products = new ArrayList<>();
        }

        public void add(int num) {
            if (num == 0) {
                products.clear();
                return;
            }
            if (products.isEmpty()) {
                products.add((long)num);
            } else {
                products.add(products.get(products.size()-1)*num);
            }
        }

        public int getProduct(int k) {
            if (products.size() < k) {
                return 0;
            } else if (products.size() == k) {
                return products.get(products.size()-1).intValue();
            } else {
                long total = products.get(products.size()-1);
                long pre = products.get(products.size()-1-k);
                return (int)(total/pre);
            }
        }
    }
}

import java.util.HashMap;

public class S1357ApplyDiscountEverynOrders {
    class Cashier {
        int N;
        int DISCOUNT;
        int customer = 0;
        HashMap<Integer, Integer> price = new HashMap<>();

        public Cashier(int n, int discount, int[] products, int[] prices) {
            this.N = n;
            this.DISCOUNT = discount;
            for (int i = 0; i < products.length; i++) {
                price.put(products[i], prices[i]);
            }
        }

        public double getBill(int[] product, int[] amount) {
            double sum = 0;
            for (int i = 0; i < product.length; i++) {
                sum += 1.0*price.get(product[i])*amount[i];
            }
            if (customer == N-1) {
                sum = sum - (DISCOUNT * sum)/100;
            }
            customer = (customer+1)%N;
            return sum;
        }
    }
}

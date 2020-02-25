public class S1359CountAllValidPickupDeliveryOptions {
    public int countOrders(int n) {
        if (n == 1) {
            return 1;
        }
        int MOD = (int)Math.pow(10, 9)+7;
        long res = (2*(n-1)+2)*(2*(n-1)+1)/2;
        res = (res * countOrders(n-1)) % MOD;
        return (int) res;
    }
}

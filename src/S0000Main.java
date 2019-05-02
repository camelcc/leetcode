import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0188BestTimeBuySellStockIV stock = new S0188BestTimeBuySellStockIV();
        StdOut.println(stock.maxProfit(2, new int[]{2,1,4,5,2,9,7}));
    }
}

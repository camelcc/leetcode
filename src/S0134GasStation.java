public class S0134GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int N = gas.length;
        int res = 0;
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        for (int i = 0; i < N; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i]-cost[i];
            if (tank < 0) {
                res = i + 1;
                tank = 0;
            }
        }
        if (totalGas < totalCost) {
            return -1;
        } else {
            return res;
        }
    }
}

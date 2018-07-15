public class S0134GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int N = gas.length;
        for (int i = 0; i < N; i++) {
            if (cost[i] > gas[i]) {
                continue;
            }

            boolean end = true;
            int car = 0;
            for (int start = i; start < i + N; start++) {
                car += gas[(start+N)%N];
                car -= cost[(start+N)%N];
                if (car < 0) {
                    end = false;
                    break;
                }
            }
            if (!end) {
                continue;
            }

            return i;
        }
        return -1;
    }
}

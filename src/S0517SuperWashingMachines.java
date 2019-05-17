public class S0517SuperWashingMachines {
    public int findMinMoves(int[] machines) {
        if (machines.length <= 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < machines.length; i++) {
            sum += machines[i];
        }
        if (sum%machines.length != 0) {
            return -1;
        }
        int avg = sum/machines.length;

        int res = 0;
        int prev = 0;
        for (int i = 0; i < machines.length; i++) {
            prev += machines[i]-avg;
            res = Math.max(Math.max(res, Math.abs(prev)), machines[i]-avg);
        }
        return res;
    }
}

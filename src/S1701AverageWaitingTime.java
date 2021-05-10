public class S1701AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        double total = 0;
        long chef = 0;
        for (int i = 0; i < customers.length; i++) {
            int arrival = customers[i][0], time = customers[i][1];
            chef = Math.max(chef + time, arrival + time);
            total += chef-arrival;
        }
        return total/customers.length;
    }
}

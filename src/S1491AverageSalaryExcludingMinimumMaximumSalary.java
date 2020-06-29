public class S1491AverageSalaryExcludingMinimumMaximumSalary {
    public double average(int[] salary) {
        int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int s : salary) {
            sum += s;
            min = Math.min(min, s);
            max = Math.max(max, s);
        }
        return (sum-min-max)*1.0/(salary.length-2);
    }
}

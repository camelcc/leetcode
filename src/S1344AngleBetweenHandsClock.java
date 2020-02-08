public class S1344AngleBetweenHandsClock {
    public double angleClock(int hour, int minutes) {
        double h = ((hour%12)*5 + minutes*5.0/60);
        double range = 360.0*Math.abs(h-minutes)/60;
        return Math.min(range, 360-range);
    }
}

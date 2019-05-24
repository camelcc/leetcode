import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0732MyCalendarIII.MyCalendarThree calendar = new S0732MyCalendarIII.MyCalendarThree();
        StdOut.println(calendar.book(10, 20));
        StdOut.println(calendar.book(50, 60));
        StdOut.println(calendar.book(10, 40));
        StdOut.println(calendar.book(5, 15));
        StdOut.println(calendar.book(5, 10));
        StdOut.println(calendar.book(25, 55));
    }
}

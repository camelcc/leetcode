import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class S0729MyCalendarI {
    class MyCalendar {
        List<int[]> books;
        private Comparator<int[]> comp;

        public MyCalendar() {
            books = new ArrayList<>();
            comp = new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    int t = o1[0]-o2[0];
                    if (t == 0) {
                        return o1[1]-o2[1];
                    } else {
                        return t;
                    }
                }
            };
        }

        public boolean book(int start, int end) {
            int p = Collections.binarySearch(books, new int[]{start, end}, comp);
            if (p >= 0) {
                return false;
            }
            p = -(p+1);

            // [start] >= end
            if (p > 0 && books.get(p-1)[1] > start) {
                return false;
            }
            // [end] <= start
            if (p < books.size() && books.get(p)[0] < end) {
                return false;
            }
            books.add(p, new int[]{start, end});
            return true;
        }
    }
}

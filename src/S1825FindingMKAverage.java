import java.util.*;

public class S1825FindingMKAverage {
    public static class MKAverage {
        HashMap<Integer, Integer> data;
        TreeSet<Integer> lower, middle, high;
        long sum = 0;
        int M = 0, K = 0, index = 0;

        public MKAverage(int m, int k) {
            data = new HashMap<>();
            lower = new TreeSet<>((o1, o2) -> {
                if (data.get(o1) != data.get(o2)) {
                    return data.get(o1) - data.get(o2);
                }
                return o1-o2;
            });
            middle = new TreeSet<>((o1, o2) -> {
                if (data.get(o1) != data.get(o2)) {
                    return data.get(o1) - data.get(o2);
                }
                return o1-o2;
            });
            high = new TreeSet<>((o1, o2) -> {
                if (data.get(o1) != data.get(o2)) {
                    return data.get(o1) - data.get(o2);
                }
                return o1-o2;
            });
            M = m;
            K = k;
        }

        public void addElement(int num) {
            if (data.size() < M) {
                data.put(index, num);
                if (lower.size() < K) {
                    lower.add(index);
                } else { // lower.size == K
                    assert lower.size() == K;
                    int v = num, i = index;
                    if (v < data.get(lower.last())) {
                        lower.add(index);
                        i = lower.pollLast();
                        v = data.get(i);
                    }
                    if (middle.size() < M-2*K) {
                        middle.add(i);
                        sum += v;
                    } else { // middle.size == M-2K
                        assert middle.size() == M-2*K;
                        if (v < data.get(middle.last())) {
                            middle.add(i);
                            sum += v;
                            i = middle.pollLast();
                            v = data.get(i);
                            sum -= v;
                        }
                        high.add(i);
                    }
                }
                index++;
            } else {
                assert data.size() == M;
                int i = index-M;
                if (lower.contains(i)) {
                    lower.remove(i);
                    data.remove(i);

                    int mi = middle.pollFirst();
                    lower.add(mi);
                    sum -= data.get(mi);

                    int hi = high.pollFirst();
                    middle.add(hi);
                    sum += data.get(hi);
                } else if (middle.contains(i)) {
                    middle.remove(i);
                    sum -= data.remove(i);

                    int hi = high.pollFirst();
                    middle.add(hi);
                    sum += data.get(hi);
                } else if (high.contains(i)) {
                    high.remove(i);
                    data.remove(i);
                } else {
                    throw new NullPointerException("index not exist");
                }
                addElement(num);
            }
        }

        public int calculateMKAverage() {
            if (data.size() < M) {
                return -1;
            }
            return (int)(Math.floor(sum*1.0/(M-2*K)));
        }
    }
}

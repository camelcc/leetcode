import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class S0341FlattenNestedListIterator {
    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        Stack<Iterator<NestedInteger>> iterators = new Stack<>();
        Integer next = null;

        public NestedIterator(List<NestedInteger> nestedList) {
            iterators.push(nestedList.iterator());
        }

        @Override
        public Integer next() {
            return next;
        }

        @Override
        public boolean hasNext() {
            if (iterators.empty()) {
                return false;
            }

            Iterator<NestedInteger> iter = iterators.peek();
            if (!iter.hasNext()) {
                iterators.pop();
                return hasNext();
            }

            NestedInteger nestedInteger = iter.next();
            if (nestedInteger.isInteger()) {
                next = nestedInteger.getInteger();
                return true;
            }

            next = null;
            List<NestedInteger> list = nestedInteger.getList();
            iterators.push(list.iterator());
            return hasNext();
        }
    }
}

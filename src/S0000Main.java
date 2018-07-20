public class S0000Main {
    public static void main(String[] args) {
        S0148SortList list = new S0148SortList();
        S0148SortList.ListNode l = new S0148SortList.ListNode(4);
        S0148SortList.ListNode h = l;
        l.next = new S0148SortList.ListNode(2);
        l = l.next;
        l.next = new S0148SortList.ListNode(1);
        l = l.next;
        l.next = new S0148SortList.ListNode(3);
        list.sortList(h);
    }
}

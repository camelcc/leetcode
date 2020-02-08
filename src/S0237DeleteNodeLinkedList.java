import util.ListNode;

public class S0237DeleteNodeLinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        if (node.next.next == null) {
            node.next = null;
        } else {
            node.next = node.next.next;
        }
    }
}

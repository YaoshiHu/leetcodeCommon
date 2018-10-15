package common;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {val = x;}
    public ListNode(int[] arr) {
        if(arr.length == 0) {
            val = 0;
            return;
        }
        val = arr[0];
        next = addNext(arr, 1, null, null);
    }

    private ListNode addNext(int[] arr, int i, ListNode node, ListNode head) {
        if(i == arr.length) return head;
        if(node == null) {
            node = new ListNode(arr[i]);
            head = node;
            return addNext(arr, i+1, node, head);
        }
        node.next = new ListNode(arr[i]);
        return addNext(arr, i+1, node.next, head);
    }

    @Override
    public String toString() {
        if(next == null) return Integer.toString(val);
        return val + ", " + next.toString();
    }
}

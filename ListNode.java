package common;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {val = x;}

    @Override
    public String toString() {
        if(next == null) return Integer.toString(val);
        return Integer.toString(val) + ", " + next.toString();
    }
}

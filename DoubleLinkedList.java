package common;

import java.util.*;

public class DoubleLinkedList<T> {
    public T val;
    public DoubleLinkedList<T> next;
    public DoubleLinkedList<T> pre;

    public DoubleLinkedList(T val) {this.val = val;}

    // return head, tail, and in the meanwhile, check if the list is a valid list
    public List<DoubleLinkedList<T>> getHeadTail() {
        Set<DoubleLinkedList<T>> nodeSet = new HashSet<>();
        DoubleLinkedList<T> tmp = this;
        while(tmp.next != null) {
            if(nodeSet.contains(tmp)) return null;
            nodeSet.add(tmp);
            if(!tmp.equals(tmp.next.pre)) return null;
            tmp = tmp.next;
        }
        DoubleLinkedList<T> tail = tmp;
        DoubleLinkedList<T> head;
        List<DoubleLinkedList<T>> result = new ArrayList<>();
        if(this.pre == null) {
            head = this;
            result.add(head);
            result.add(tail);
            return result;
        }
        tmp = this.pre;
        while(tmp.pre != null) {
            if(nodeSet.contains(tmp)) return null;
            nodeSet.add(tmp);
            if(!tmp.equals(tmp.pre.next)) return null;
            tmp = tmp.pre;
        }
        head = tmp;
        result.add(head);
        result.add(tail);
        return result;
    }

    @Override
    public String toString() {
        List<DoubleLinkedList<T>> list = getHeadTail();
        if(list == null) return "The given LinkedList is not valid";
        DoubleLinkedList head = list.get(0);
        StringBuilder sb = new StringBuilder();
        while(head != null) {
            sb.append(head.val.toString());
            if(head.next != null) sb.append(", ");
            head = head.next;
        }
        return sb.toString();
    }
}
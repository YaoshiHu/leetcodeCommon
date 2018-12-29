package common;

import java.util.*;

public class UnionFind<E> {
    Map<E, E> parents;
    Map<E, Integer> rank;

    public UnionFind() {
        parents = new HashMap<>();
        rank = new HashMap<>();
    }

    public E find(E node) {
        if(!parents.containsKey(node)) {System.out.printf("Object %s is not in the union\n", node); return null;}
        if(!parents.get(node).equals(node)) parents.put(node, find(parents.get(node)));
        return parents.get(node);
    }

    public boolean merge(E node1, E node2) {
        if(node1.equals(node2)) {parents.put(node1, node1); return false;}
        if(!parents.containsKey(node1) && !parents.containsKey(node2)) {
            parents.put(node1, node1);
            parents.put(node2, node1);
            rank.put(node1, rank.getOrDefault(node1, 0)+1);
        } else if(!parents.containsKey(node1)) {
            E p = find(node2);
            parents.put(node1, p);
            rank.put(p, rank.getOrDefault(p, 0)+1);
        } else if(!parents.containsKey(node2)) {
            E p = find(node1);
            parents.put(node2, p);
            rank.put(p, rank.getOrDefault(p, 0)+1);
        } else {
            E p1 = find(node1);
            E p2 = find(node2);
            if(p1.equals(p2)) return false;
            if(rank.getOrDefault(p1, 0) > rank.getOrDefault(p2, 0)) {
                parents.put(p2, p1);
                rank.put(p1, rank.getOrDefault(p1, 0)+1);
            } else {
                parents.put(p1, p2);
                rank.put(p2, rank.getOrDefault(p2, 0)+1);
            }
        }
        return true;
    }
}

class UnionFindTest {
    public static void main(String[] args) {
        UnionFind<String> union = new UnionFind<>();
        for(int i = 0; i < 10; i++) {
            union.merge(Integer.toString(i), Integer.toString(2*i));
        }
        for(int i = 0; i < 10; i++) System.out.printf("%d: %s\n", i, union.find(Integer.toString(i)));
        for(int i = 10; i < 20; i+=2) System.out.printf("%d: %s\n", i, union.find(Integer.toString(i)));
    }
}
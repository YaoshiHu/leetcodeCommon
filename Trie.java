package common;

import java.util.*;

public class Trie {
    class Node {
        Map<Character, Node> child;
        int prefix_cnt;
        boolean isLeaf;

        Node() {
            child = new HashMap<>();
        }

        List<String> getAllWords() {
            List<String> list = new ArrayList<>();
            for(char c : child.keySet()) {
                help(child.get(c), new StringBuilder().append(c), list);
            }
            return list;
        }

        private void help(Node node, StringBuilder sb, List<String> list) {
            if(node.isLeaf) list.add(sb.toString());
            for(char c : node.child.keySet()) {
                help(node.child.get(c), new StringBuilder(sb).append(c), list);
            }
        }
    }
    Node root;
    public Trie() {
        root = new Node();
    }

    public boolean insert(Node node, String word, int index) {
        if(index == word.length()) {
            if(node.isLeaf) return false;
            node.isLeaf = true;
            return true;
        }
        char key = word.charAt(index);
        if(!node.child.containsKey(key)) {
            node.child.put(key, new Node());
        }
        boolean exist = insert(node.child.get(key), word, index+1);
        if(exist) return false;
        node.prefix_cnt++;
        return true;
    }

    public boolean insert(String word) {
        return insert(root, word, 0);
    }

    public List<String> getAllWords() {
        return root.getAllWords();
    }
}

class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("Word");
        trie.insert("Test");
        trie.insert("Tree");
        trie.insert("World");
        trie.insert("Tree");
        System.out.println(trie.getAllWords());
    }
}

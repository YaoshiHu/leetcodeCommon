package common;

public class TreeNodes {
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        return root == null ? "null":Integer.toString(root.val) + " " + serialize(root.left) + " " + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] split = data.split(" ");
        return deserializeAux(split, new int[]{0});
    }

    private static TreeNode deserializeAux(String[] split, int[] index) {
        String stringVal = split[index[0]];
        index[0] += 1;
        if(stringVal.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(stringVal));
        node.left = deserializeAux(split, index);
        node.right = deserializeAux(split, index);
        return node;
    }
}

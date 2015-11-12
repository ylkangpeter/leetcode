package peter;

import util.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by ylkang on 10/26/15.
 */
public class _297_Serialize_and_Deserialize_Binary_Tree {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<Integer> list = new LinkedList<Integer>();

        LinkedList<TreeNode>[] stacks = new LinkedList[2];
        stacks[0] = new LinkedList<>();
        stacks[0].push(root);
        stacks[1] = new LinkedList<>();

        int i = 0;
        boolean isContinue = true;

        int total = 0;
        while (isContinue) {
            isContinue = false;
            while (!stacks[i % 2].isEmpty()) {
                TreeNode node = stacks[i % 2].pop();
                if (node == null) {
                    list.add(null);
                } else {
                    list.add(node.val);
                    total++;
                    if (node.left != null || node.right != null) {
                        isContinue = true;
                    }
                    stacks[(i + 1) % 2].addLast(node.left);
                    stacks[(i + 1) % 2].addLast(node.right);
                }
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (total != 0) {
            Integer val = list.removeFirst();
            if (val != null) {
                total--;
            }
            sb.append(val).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] tmps = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(tmps[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        int i = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            if (++i < tmps.length) {
                if (!tmps[i].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(tmps[i]));
                    queue.addLast(node.left);
                }
            }
            if (++i < tmps.length) {
                if (!tmps[i].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(tmps[i]));
                    queue.addLast(node.right);
                }
            }
        }
        return root;
    }


    public static void main(String[] args) {
        _297_Serialize_and_Deserialize_Binary_Tree test = new _297_Serialize_and_Deserialize_Binary_Tree();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);
        System.out.println(
                test.serialize(root));

//        TreeNode a = test.deserialize("[1,2,3,null,null,4,5]");
        System.out.println(test.deserialize(test.serialize(root)));
    }

}

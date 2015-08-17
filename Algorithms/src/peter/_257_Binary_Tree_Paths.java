package peter;

import util.Util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ylkang on 8/17/15.
 */
public class _257_Binary_Tree_Paths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if (root == null) {
            return list;
        }
        LinkedList<Integer> L_List = new LinkedList<Integer>();
        L_List.add(root.val);
        binaryTreePaths(list, root, L_List);
        return list;
    }

    private void binaryTreePaths(List<String> result, TreeNode root, LinkedList<Integer> tmpList) {

        if (root.left == null && root.right == null) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < tmpList.size(); i++) {
                tmp.append(tmpList.get(i)).append("->");
            }
            tmp.delete(tmp.length() - 2, tmp.length());
            result.add(tmp.toString());
            return;
        }

        if (root.left != null) {
            tmpList.add(root.left.val);
            binaryTreePaths(result, root.left, tmpList);
            tmpList.removeLast();

        }
        if (root.right != null) {
            tmpList.add(root.right.val);
            binaryTreePaths(result, root.right, tmpList);
            tmpList.removeLast();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(new _257_Binary_Tree_Paths().binaryTreePaths(root));
    }
}

/**
 * project info: leetcode-peter
 */

package peter;

import java.util.Stack;

/**
 * You are given a doubly linked list which in addition to the next and previous pointers, it could have a child
 * pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more
 * children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
 * <p>
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the
 * first level of the list.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 * Explanation:
 * <p>
 * The multilevel linked list in the input is as follows:
 * <p>
 * <p>
 * <p>
 * After flattening the multilevel linked list it becomes:
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,2,null,3]
 * Output: [1,3,2]
 * Explanation:
 * <p>
 * The input multilevel linked list is as follows:
 * <p>
 * 1---2---NULL
 * |
 * 3---NULL
 * Example 3:
 * <p>
 * Input: head = []
 * Output: []
 *  
 * <p>
 * How multilevel linked list is represented in test case:
 * <p>
 * We use the multilevel linked list from Example 1 above:
 * <p>
 * 1---2---3---4---5---6--NULL
 * |
 * 7---8---9---10--NULL
 * |
 * 11--12--NULL
 * The serialization of each level is as follows:
 * <p>
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * To serialize all levels together we will add nulls in each level to signify no node connects to the upper node of
 * the previous level. The serialization becomes:
 * <p>
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * Merging the serialization of each level and removing trailing nulls we obtain:
 * <p>
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 *  
 * <p>
 * Constraints:
 * <p>
 * The number of Nodes will not exceed 1000.
 * 1 <= Node.val <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _430_Flatten_a_Multilevel_Doubly_Linked_List {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }


    public Node flatten(Node head) {
        Node node = head;
        Node prev = null;
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node == null) {
                node = stack.pop();
                node.prev = prev;
                prev.next = node;
            }
            if (node.child != null) {
                if (node.next != null) {
                    stack.push(node.next);
                }
                node.child.prev = node;
                node.next = node.child;
                node.child = null;
            }
            prev = node;
            node = node.next;
        }
        return head;

    }
}

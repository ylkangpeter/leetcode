package peter;

import util.Util.ListNode;

/**
 * Created by ylkang on 7/15/15.
 */
public class _237_Delete_Node_in_a_Linked_List {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}

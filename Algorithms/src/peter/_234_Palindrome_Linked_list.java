package peter;

import util.Util.ListNode;

/**
 * Created by ylkang on 7/13/15.
 */
public class _234_Palindrome_Linked_list {


    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        tmp = reverseList(tmp);

        while (tmp != null && head != null) {
            if (tmp.val != head.val) {
                return false;
            }
            tmp = tmp.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newNode = head;
        head = head.next;
        newNode.next = null;

        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = newNode;
            newNode = tmp;
        }

        return newNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(33);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        _234_Palindrome_Linked_list a = new _234_Palindrome_Linked_list();
        System.out.println(a.isPalindrome(head));
    }
}

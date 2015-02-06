package peter;

import java.util.List;

import util.Util.ListNode;

public class _023_Merge_k_Sorted_Lists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode h = new ListNode(0);
		ListNode tmp = h;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				tmp.next = l1;
				l1 = l1.next;
			} else {
				tmp.next = l2;
				l2 = l2.next;
			}
			tmp = tmp.next;
		}

		if (l1 != null) {
			tmp.next = l1;
		}

		if (l2 != null) {
			tmp.next = l2;
		}
		return h.next;

	}

	public ListNode mergeKLists(List<ListNode> lists) {
		for (int i = 1; i < lists.size(); i *= 2)
			for (int j = 0; j + i < lists.size(); j += 2 * i)
				lists.set(j, mergeTwoLists(lists.get(j), lists.get(j + i)));
		return lists.size() == 0 ? null : lists.get(0);
	}

}
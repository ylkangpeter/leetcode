package peter;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import util.Util.RandomListNode;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * @author ylkang Mar 10, 2015
 */
public class _138_Copy_List_with_Random_Pointer {

	public static RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		RandomListNode root = head;
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

		while (head != null) {
			map.put(head, new RandomListNode(head.label));
			head = head.next;
		}

		for (Entry<RandomListNode, RandomListNode> entry : map.entrySet()) {
			RandomListNode next = entry.getKey().next;
			RandomListNode cloneNext = map.get(next);
			entry.getValue().next = cloneNext;

			RandomListNode random = entry.getKey().random;
			RandomListNode cloneRandom = map.get(random);
			entry.getValue().random = cloneRandom;

		}

		return map.get(root);
	}

	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(1);
		RandomListNode a = new RandomListNode(2);
		RandomListNode b = new RandomListNode(3);
//		b.next = head;
		head.next = a;
		a.next = b;
//		head.random = head;
		a.random = b;
		b.random = a;
		System.out.println(copyRandomList(head));
		System.out.println();
	}
}
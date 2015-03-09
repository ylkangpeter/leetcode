package peter;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. set(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 * 
 * @author ylkang Mar 2, 2015
 */
public class _146_LRU_Cache {

	private Entry header = null;

	private Entry tail = null;

	private static class Entry {
		int key;
		int val;
		Entry pre;
		Entry next;

	}

	private int size;

	private Map<Integer, Entry> map = new HashMap<Integer, Entry>();

	public _146_LRU_Cache(int capacity) {
		this.map = new HashMap<Integer, Entry>(2 * capacity);
		this.size = capacity;
	}

	public int get(int key) {
		Entry entry = map.get(key);
		if (entry == null) {
			return -1;
		} else {
			manipulateEntry(entry);
			return entry.val;
		}
	}

	private void manipulateEntry(Entry entry) {
		Entry next = entry.next;
		Entry pre = entry.pre;
		if (next == null) {
			tail = pre;
		}
		if (pre != null) {
			pre.next = next;
			if (next != null) {
				next.pre = pre;
			}
			entry.next = header;
			entry.pre = null;
			header.pre = entry;
			header = entry;
		}

		if (tail == null) {
			tail = entry;
		}
	}

	public void set(int key, int value) {
		if (size == 0) {
			return;
		}
		Entry entry = map.get(key);
		if (entry == null) {
			entry = new Entry();
			entry.key = key;
			entry.val = value;
			entry.next = header;
			if (header != null) {
				header.pre = entry;
			}
			header = entry;

			if (map.size() == size) {
				if (tail != null) {
					Entry last = tail.pre;
					if (last != null) {
						last.next = null;
					}
					map.remove(tail.key);
					tail = last;
				}
			}
		} else {
			entry.val = value;
			entry.key = key;
			manipulateEntry(entry);
		}
		if (tail == null) {
			tail = entry;
		}
		map.put(key, entry);
	}

	public static void main(String[] args) {
		_146_LRU_Cache lru = new _146_LRU_Cache(3);
		lru.set(1, 1);
		lru.set(2, 2);
		lru.set(3, 3);
		lru.set(4, 4);
		System.out.println(lru.get(4));
		System.out.println(lru.get(3));
		System.out.println(lru.get(2));
		System.out.println(lru.get(1));
		lru.set(5, 5);
		System.out.println(lru.get(4));
		System.out.println(lru.get(3));
		System.out.println(lru.get(2));
		System.out.println(lru.get(1));
		System.out.println(lru);
	}
}
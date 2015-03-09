package peter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example: Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * @author ylkang Mar 3, 2015
 */
public class _093_Restore_IP_Addresses {

	public static List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		if (s == null || s.length() < 4 || s.length() > 12) {
			return list;
		}

		int counter = 4;

		int minStart = s.length() - 3 * (counter - 1);
		minStart = minStart < 0 ? 1 : minStart;
		minStart = minStart > 0 ? minStart : 1;
		for (int i = minStart; i <= 3; i++) {
			int ip = Integer.parseInt(s.substring(0, i));
			if (ip > 255 || String.valueOf(ip).length() != i) {
				break;
			}
			fill(set, s, i, counter - 1, String.valueOf(ip));
		}
		list.addAll(set);
		return list;
	}

	private static void fill(Set<String> set, String s, int usedLength,
			int counter, String string) {
		if (usedLength == s.length()) {
			if (counter == 0) {
				set.add(string);
			} else {
				return;
			}
		} else {
			int minStart = s.length() - 1 - 3 * (counter - 1);
			minStart = minStart <= 0 ? usedLength : minStart;
			minStart = minStart > usedLength ? minStart : usedLength;
			for (int j = minStart + 1; j <= usedLength + 3 && j <= s.length(); j++) {
				int ip = Integer.parseInt(s.substring(usedLength, j));
				if (ip > 255 || String.valueOf(ip).length() != (j - usedLength)) {
					counter = 1;
					break;
				}
				String tmp = string + "." + ip;
				fill(set, s, j, counter - 1, tmp);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("010010"));
	}
}
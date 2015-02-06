package peter;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth
 * sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _038_Count_and_Say {

	public String countAndSay(int n) {
		String s = "1";
		for (int i = 2; i <= n; i++) {
			StringBuilder sb = new StringBuilder();
			char pre = s.charAt(0);
			int counter = 1;
			for (int j = 1; j < s.length(); j++) {
				if (s.charAt(j) == pre) {
					counter++;
				} else {
					sb.append(counter);
					sb.append(pre);
					pre = s.charAt(j);
					counter = 1;
				}
			}
			if (counter != 0) {
				sb.append(counter);
				sb.append(pre);
			}
			s = sb.toString();
		}
		return s;

	}

}
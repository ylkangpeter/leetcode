package peter;

/**
 * 
 * @author ylkang Feb 5, 2015
 */
public class _151_Reverse_Words_in_a_String {

	public String reverseWords(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		StringBuilder tmp = new StringBuilder();
		int inx = s.length() - 1;
		while (inx >= 0) {
			while (inx >= 0 && s.charAt(inx) == ' ') {
				inx--;
			}
			while (inx >= 0 && s.charAt(inx) != ' ') {
				tmp.append(s.charAt(inx));
				inx--;
			}
			if (tmp.length() == s.length()) {
				return s;
			}
			for (int i = tmp.length() - 1; i >= 0; i--) {
				sb.append(tmp.charAt(i));
			}
			if (sb.length() > 0)
				sb.append(" ");
			tmp = new StringBuilder();
			inx--;
		}
		for (int i = sb.length() - 1; i >= 0; i--) {
			if (sb.charAt(i) == ' ') {
				sb.deleteCharAt(i);
			} else {
				break;
			}
		}
		return sb.toString();

		/*
		 * a bcbba cidm oop m qm 12345 1 bcbba cidm oop m qm 1234a 5 12bcbba
		 * cidm oop m qm 123 a 54 123cbba cidm oop m qm 12a a 54 12345 q m oop
		 * cidm b a
		 */

	}

}
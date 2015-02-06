package peter;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100"
 * 
 * @author ylkang Feb 5, 2015
 */
public class _067_Add_Binary {

	public String addBinary(String a, String b) {
		if (a == null || a.equals("")) {
			return b;
		}
		if (b == null || b.equals("")) {
			return a;
		}

		int i = 0;

		StringBuilder s = new StringBuilder();
		for (; i < Math.abs(a.length() - b.length()); i++) {
			s.append("0");
		}

		if (a.length() < b.length()) {
			a = s.toString() + a;
		} else {
			b = s.toString() + b;
		}

		StringBuffer sb = new StringBuffer();

		int promotion = 0;
		for (i = a.length() - 1; i >= 0; i--) {
			int val = a.charAt(i) - 48 + promotion + (b.charAt(i) - 48);
			promotion = (val & 2) >> 1;
			val = val & 1;
			sb.append(val);
		}
		if (promotion != 0) {
			sb.append(1);
		}
		if (sb.toString().equals(""))
			return "0";
		return sb.reverse().toString();
	}

}
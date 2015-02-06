package peter;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * <pre>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * </pre>
 * 
 * And then read line by line: "PAHNAPLSIIGYIR" Write the code that will take a
 * string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3) should
 * return "PAHNAPLSIIGYIR".
 * 
 * @author ylkang Feb 5, 2015
 */
public class _004_Median_of_Two_Sorted_Arrays {

	public String convert(String s, int nRows) {
		if (nRows == 1 || nRows >= s.length()) {
			return s;
		}

		StringBuilder sb = new StringBuilder();

		char[] chars = s.toCharArray();

		// 1st line
		int inx = 0;
		while (inx < s.length()) {
			sb.append(chars[inx]);
			inx += 2 * nRows - 2;
		}

		// 2nd to n-1 line
		for (int i = 1; i < nRows - 1; i++) {
			inx = i;
			boolean leftBorder = true;
			while (inx < s.length()) {
				sb.append(chars[inx]);
				if (!leftBorder) {
					inx += 2 * i;
					if (inx < s.length()) {
						sb.append(chars[inx]);
					}
				}
				leftBorder = false;
				inx += 2 * (nRows - i - 1);
			}
		}

		// last line
		inx = nRows - 1;
		while (inx < s.length()) {
			sb.append(chars[inx]);
			inx += 2 * nRows - 2;
		}
		return sb.toString();
	}

}
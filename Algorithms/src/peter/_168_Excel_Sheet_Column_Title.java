package peter;

/**
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
 * 
 * @author ylkang Feb 5, 2015
 */
public class _168_Excel_Sheet_Column_Title {

	private char[] c_array = { 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
			'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
			'V', 'W', 'X', 'Y', '0' };

	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();

		int radix = 26;
		int left = n;
		while (left > 0) {
			left = n / radix;
			int mod = n % radix;
			if (mod == 0) {
				left--;
			}
			n = left;
			sb.append(c_array[mod]);
		}
		return sb.reverse().toString();

	}

}
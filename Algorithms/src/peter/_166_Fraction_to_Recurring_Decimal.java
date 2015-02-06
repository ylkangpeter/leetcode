package peter;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * For example,
 * 
 * <pre>
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * </pre>
 * 
 * @author ylkang Feb 5, 2015
 */
public class _166_Fraction_to_Recurring_Decimal {

	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		StringBuilder sb = new StringBuilder();

		boolean isNeg = (numerator > 0) ^ (denominator > 0);

		if (isNeg) {
			sb.append("-");
		}
		long b = denominator < 0 ? -1 * ((long) denominator) : denominator;
		long a = numerator < 0 ? -1 * ((long) numerator) : numerator;

		Map<Long, Integer> map = new HashMap<Long, Integer>();
		long times = a / b;
		a = a % b;

		if (times > 0) {
			sb.append(times);
		} else {
			sb.append("0");
		}
		if (a == 0) {
			return sb.toString();
		}
		sb.append(".");

		map.put(a, sb.length());
		while (a > 0) {
			a *= 10;
			sb.append(a / b);
			a %= b;
			if (map.containsKey(a)) {
				sb.insert(map.get(a), "(");
				return sb.toString() + ")";
			}
			map.put(a, sb.length());
		}

		return sb.toString();
	}

}
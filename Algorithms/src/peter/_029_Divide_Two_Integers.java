package peter;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT.
 * 
 * @author ylkang Jun 5, 2015
 */
public class _029_Divide_Two_Integers {

	public int divide(int dividend, int divisor) {
		if (dividend == 0) {
			return 0;
		}
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}
		if (divisor == 1) {
			return dividend;
		}
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		boolean isNeg = dividend > 0 ^ divisor > 0;

		dividend = dividend > 0 ? -dividend : dividend;
		divisor = divisor > 0 ? -divisor : divisor;

		if (dividend > divisor) {
			return 0;
		}

		int result = 0;
		while (dividend <= divisor) {
			long tmp = divisor;
			long val = 1;
			while (dividend < tmp) {
				val <<= 1;
				tmp <<= 1;
			}
			if (dividend > tmp) {
				val >>= 1;
				tmp >>= 1;
			}

			dividend = dividend - (int) tmp;
			result += val;
		}

		result = isNeg ? -result : result;

		return result;
	}

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(123));
		System.out.println(Integer.toBinaryString(3));
		long s = System.currentTimeMillis();
		System.out.println(new _029_Divide_Two_Integers().divide(-1010369383,
				-2147483648));
		System.out.println(System.currentTimeMillis() - s);
		s = System.currentTimeMillis();
		System.out.println(System.currentTimeMillis() - s);
	}
}
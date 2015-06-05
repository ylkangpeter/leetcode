package peter;

public class _069_Sqrtx {
	public int mySqrt(int x) {
		if (x <= 0) {
			return 0;
		}
		int len = Integer.toBinaryString(x).length();
		int guessNum = x >> (len / 2);

		return test(x, guessNum);
	}

	private int test(double x, double g) {
		if (closeEnough(x / g, g))
			return (int) g;
		else
			return test(x, betterGuess(x, g));
	}

	private boolean closeEnough(double a, double x) {
		return (Math.abs(a - x) < .01);
	}

	private double betterGuess(double x, double g) {
		return ((g + x / g) / 2);
	}

	public static void main(String[] args) {
		System.out.println(new _069_Sqrtx().mySqrt(2063520907));

		System.out.println(Math.sqrt(Integer.MAX_VALUE));
	}
}
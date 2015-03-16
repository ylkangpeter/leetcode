package peter;

/**
 * 
 * @author ylkang Feb 25, 2015
 */
public class _050_Pow {

	public double pow(double x, int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		if (n == 2)
			return x * x;
		if (n < 0) {
			if (n == Integer.MIN_VALUE) {
				n = Integer.MAX_VALUE;
			} else {
				n = -n - 1;
			}
			return 1 / (pow(x, n) * x);
		}

		if (n % 2 == 0)
			return pow(pow(x, n / 2), 2);
		else
			return x * pow(x, n - 1);
	}

	public static void main(String[] args) {
		System.out.println(0.000000000000000000000100000000000000000000001);
	}
}
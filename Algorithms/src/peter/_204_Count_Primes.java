package peter;

import java.util.BitSet;

public class _204_Count_Primes {

	public int countPrimes(int n) {
		if (n < 3) {
			return 0;
		}

		BitSet status = new BitSet(n - 2);
		for (int i = 2; i <= Math.sqrt(n - 1); i++) {
			if (status.get(i - 2)) {
				continue;
			}
			for (int j = i; j <= (n - 1) / i; j++) {
				status.set(i * j - 2);
			}
		}

		int result = 0;
		for (int i = 0; i < n - 2; i++) {
			if (!status.get(i)) {
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new _204_Count_Primes().countPrimes(15000));
	}
}

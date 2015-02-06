package peter;

public class _070_Climbing_Stairs {

	int climbStairs(int n) {
		if (n <= 2)
			return n;
		int a = 1, b = 2, c = 0;
		for (int i = 0; i < n - 2; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
}
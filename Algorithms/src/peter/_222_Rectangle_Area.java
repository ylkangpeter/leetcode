package peter;

public class _222_Rectangle_Area {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {

		int v = calc(A, B, C, D, E, F, G, H);
		if (v < 0) {
			v = calc(E, F, G, H, A, B, C, D);
		}
		if (v < 0)
			return (C - A) * (D - B) + (G - E) * (H - F);
		return (C - A) * (D - B) + (G - E) * (H - F) - v;
	}

	private int calc(int A, int B, int C, int D, int E, int F, int G, int H) {
		if (isInside(A, B, C, D, E, F)) {
			int rightX = Math.min(C, G);
			int upY = Math.min(D, H);
			return (rightX - E) * (upY - F);
		} else if (isInside(A, B, C, D, E, H)) {
			int rightX = Math.min(C, G);
			int downY = Math.max(B, F);
			return (rightX - E) * (H - downY);
		} else if (isInside(A, B, C, D, E, H)) {
			int leftX = Math.max(A, E);
			int downY = Math.max(F, B);
			return (G - leftX) * (H - downY);
		} else if (isInside(A, B, C, D, G, F)) {
			int leftX = Math.max(A, E);
			int upY = Math.min(D, H);
			return (G - leftX) * (upY - F);
		}
		return -1;
	}

	private boolean isInside(int a, int b, int c, int d, int e, int f) {
		if (a <= e && c >= e && b <= f && d >= f) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new _222_Rectangle_Area().computeArea(-2, -2, 2, 2,
				-3, -3, -1, -1));
		System.out.println(new _222_Rectangle_Area().computeArea(0, 0, 0, 0,
				-1, -1, 1, 1));
		System.out.println(new _222_Rectangle_Area().computeArea(-3, 0, 3, 4,
				0, -1, 9, 2));
	}
}

package peter;

/**
 * The demons had captured the princess (P) and imprisoned her in the
 * bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid
 * out in a 2D grid. Our valiant knight (K) was initially positioned in the
 * top-left room and must fight his way through the dungeon to rescue the
 * princess.
 * 
 * The knight has an initial health point represented by a positive integer. If
 * at any point his health point drops to 0 or below, he dies immediately.
 * 
 * Some of the rooms are guarded by demons, so the knight loses health (negative
 * integers) upon entering these rooms; other rooms are either empty (0's) or
 * contain magic orbs that increase the knight's health (positive integers).
 * 
 * In order to reach the princess as quickly as possible, the knight decides to
 * move only rightward or downward in each step.
 * 
 * 
 * Write a function to determine the knight's minimum initial health so that he
 * is able to rescue the princess.
 * 
 * For example, given the dungeon below, the initial health of the knight must
 * be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 * 
 * <pre>
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 * </pre>
 * 
 * Notes:
 * 
 * The knight's health has no upper bound. Any room can contain threats or
 * power-ups, even the first room the knight enters and the bottom-right room
 * where the princess is imprisoned.
 * 
 * @author peter
 * 
 */
public class _174_Dungeon_Game {

	/**
	 * <pre>
	 * -2 -3   3
	 * -5 -10  1
	 * 10 30  -5
	 * </pre>
	 * 
	 * @param dungeon
	 * @return
	 */
	public static int calculateMinimumHP(int[][] dungeon) {
		int length = dungeon[0].length - 1;
		int height = dungeon.length - 1;

		int min = dungeon[height][length];
		if (min > 0) {
			min = 0;
			dungeon[height][length] = -1;
		} else {
			dungeon[height][length]--;
		}

		for (int i = length - 1; i >= 0; i--) {
			if (dungeon[height][i] == 0) {
				if (dungeon[height][i + 1] < 0) {
					dungeon[height][i] = dungeon[height][i + 1];
				}
			} else if (dungeon[height][i] < 0) {
				dungeon[height][i] += dungeon[height][i + 1];
			} else {
				if (dungeon[height][i + 1] >= 0) {
					dungeon[height][i] = -1;
				} else {
					if (dungeon[height][i] + dungeon[height][i + 1] >= 0) {
						dungeon[height][i] = -1;
					} else {
						dungeon[height][i] = dungeon[height][i]
								+ dungeon[height][i + 1];
					}
				}
			}
		}

		for (int i = height - 1; i >= 0; i--) {
			if (dungeon[i][length] == 0) {
				if (dungeon[i + 1][length] < 0) {
					dungeon[i][length] = dungeon[i + 1][length];
				}
			} else if (dungeon[i][length] < 0) {
				dungeon[i][length] += dungeon[i + 1][length];
			} else {
				if (dungeon[i + 1][length] >= 0) {
					dungeon[i][length] = -1;
				} else {
					if (dungeon[i][length] + dungeon[i + 1][length] >= 0) {
						dungeon[i][length] = -1;
					} else {
						dungeon[i][length] = dungeon[i][length]
								+ dungeon[i + 1][length];
					}
				}

			}
		}

		for (int H = height - 1; H >= 0; H--) {
			for (int L = length - 1; L >= 0; L--) {
				int max = dungeon[H][L + 1] > dungeon[H + 1][L] ? dungeon[H][L + 1]
						: dungeon[H + 1][L];
				if (dungeon[H][L] < 0) {
					if (dungeon[H][L + 1] >= 0 || dungeon[H + 1][L] >= 0) {
						// dungeon[H][L] ;
					} else {
						dungeon[H][L] += max;
					}
				} else if (dungeon[H][L] > 0) {
					if (max > 0) {
						dungeon[H][L] = -1;
					} else {
						if (dungeon[H][L] + max > 0) {
							dungeon[H][L] = -1;
						} else {
							dungeon[H][L] = dungeon[H][L] + max;
						}
					}
				} else {
					dungeon[H][L] = max;
				}
			}
		}

		if (dungeon[0][0] < 0) {
			return -dungeon[0][0];
		} else {
			return 1;
		}
	}

	public static void main(String[] args) {
		int[][] dungeon = { { 1, -2, 3 }, { 2, -2, -2 } };

		// int[][] dungeon = { { 2, 1 }, { 1, -1 } };
		// int[][] dungeon = { { -3, -3, 0, 5, -1 } };
		// int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		System.out.println(calculateMinimumHP(dungeon));
	}
}
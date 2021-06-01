package dpandgreedy;

public class _95DungeonGame {

	public static void main(String[] args) {
		int[][] arr = { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, -2 } };
		System.out.println(solution(arr));

	}

	public static int solution(int[][] mat) {
		int ans = 0, i = 0, j = 0;
		int min = Integer.MAX_VALUE;
		while (i < mat.length && j < mat[0].length) {
			ans += mat[i][j];
			min = Math.min(ans, min);
			if (i == mat.length - 1) {
				j++;
			} else if (j == mat[0].length - 1) {
				i++;
			} else {
				if (mat[i + 1][j] < mat[i][j + 1]) {
					j++;
				} else {
					i++;
				}
			}
		}
		if (min > 0)
			return min;
		else
			return Math.abs(min) + 1;
	}

}

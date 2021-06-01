package dpandgreedy;

public class _66MinSumPath3dArray {

	public static void main(String[] args) {
		int arr[][][] = { { { 1, 2, 4 }, { 3, 4, 5 }, { 5, 2, 1 } }, { { 4, 8, 3 }, { 5, 2, 1 }, { 3, 4, 2 } },
				{ { 2, 4, 1 }, { 3, 1, 4 }, { 6, 3, 8 } } };
		solution(arr);
	}

	public static void solution(int[][][] arr) {
		int[][][] strg = new int[arr.length][arr[0].length][arr[0][0].length];

		for (int i = strg.length - 1; i >= 0; i--) {
			for (int j = strg[0].length - 1; j >= 0; j--) {
				for (int k = strg[0][0].length - 1; k >= 0; k--) {
					Integer min = null;
					if (i < strg.length - 1) {
						min = min == null ? strg[i + 1][j][k] : Math.min(min, strg[i + 1][j][k]);
					}

					if (j < strg[0].length - 1) {
						min = min == null ? strg[i][j + 1][k] : Math.min(min, strg[i][j + 1][k]);
					}

					if (k < strg[0][0].length - 1) {
						min = min == null ? strg[i][j][k + 1] : Math.min(min, strg[i][j][k + 1]);
					}

					strg[i][j][k] = arr[i][j][k] + (min == null ? 0 : min);
				}
			}
		}

		System.out.println(strg[0][0][0]);
	}

}

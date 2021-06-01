// Two AI playing Tic-Tac-Toe
public class tic_tac_toe {

	public static void main(String[] args) {
		int[][] arr = new int[3][3];
		int val = solve(arr, -1, 0);
		if (val == 1)
			System.out.println("1st Player wins the game");
		else if (val == -1)
			System.out.println("2nd Player wins the game");
		else
			System.out.println("It's a Draw!");

	}

	public static int solve(int[][] arr, int player, int moves) {
		if (check(arr) != 0)
			return player;
		else if (moves == 9)
			return check(arr);
		if (player == 1) {
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (arr[i][j] == 0) {
						arr[i][j] = 1;
						max = Math.max(max, solve(arr, -1, moves++));
						arr[i][j] = 0;
					}
				}
			}

			return max;
		} else {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (arr[i][j] == 0) {
						arr[i][j] = -1;
						min = Math.min(min, solve(arr, 1, moves++));
						arr[i][j] = 0;
					}
				}
			}
			return min;
		}
	}

	public static int check(int[][] arr) {
		for (int i = 0; i < 3; i++) {
			int val = 0;
			for (int j = 0; j < 3; j++) {	
				if (arr[i][j] == 0)
					break;
				else
					val += arr[i][j];
			}
			if (val == -3)
				return -1;
			if (val == 3)
				return 1;
		}
		for (int j = 0; j < 3; j++) {
			int val = 0;
			for (int i = 0; i < 3; i++) {
				if (arr[i][j] == 0)
					break;
				else
					val += arr[i][j];
			}
			if (val == -3)
				return -1;
			if (val == 3)
				return 1;
		}
		int val = 0;
		for (int i = 0; i < 3; i++) {
			if (arr[i][i] == 0)
				break;
			val += arr[i][i];
		}
		if (val == 3)
			return 1;
		if (val == -3)
			return -1;
		val = 0;
		for (int i = 2; i >= 0; i--) {
			if (arr[i][2 - i] == 0)
				break;
		}
		if (val == 3)
			return 1;
		if (val == -3)
			return -1;

		return 0;

	}

}

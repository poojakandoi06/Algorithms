package dpandgreedy;

import java.util.*;

public class _03MinJumpsToReachEnd {
	public static void main(String[] args) {
//		Scanner scn = new Scanner(System.in);
//		int n = scn.nextInt();
//		int[] arr = new int[n];
//		for(int i = 0 ; i < arr.length ;i++) {
//			arr[i] = scn.nextInt();
//		}
		int[] arr = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		solution(arr, arr.length);
	}
	private static void solution(int[] arr, int n) {
		int i = 0;
		int steps = 0;
		int paths = 1;
		while (i < n - 1) {
			if(i + arr[i] >= n - 1) {
				steps++;
				break;
			}
			int val = arr[i];
			if (val == 0) {
				System.out.println("No Solution");
				return;
			}
			int max = 0;
			int maxCount = 0;
			int nexti = 0;
			int j;
			for (j = i + 1; j < arr.length && j <= i + val; j++) {
				if (j + arr[j] > max) {
					nexti = j;
					max = j + arr[j];
				}
				if (max >= n - 1) {
					maxCount++;
				}
			}
			if (max < n - 1) {
				for (j = i + 1; j < arr.length && j <= i + val; j++) {
					if (j + arr[j] == max || j + arr[j] > n - 1) {
						maxCount++;
					}
				}
			}
			paths = maxCount * paths;
			i = nexti;
			steps++;
		}
		System.out.println(steps);
		System.out.println(paths);
	}
}

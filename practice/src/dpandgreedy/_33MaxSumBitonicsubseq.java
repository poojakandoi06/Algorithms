package dpandgreedy;

import java.util.*;

public class _33MaxSumBitonicsubseq {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		solution(arr, n);
	}

	private static void solution(int[] arr, int n) {
		int[] lis = new int[n];
		lis[0] = arr[0];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					if (lis[j] > lis[i])
						lis[i] = lis[j];
				}
			}
			lis[i] += arr[i];
		}
		int[] lds = new int[n];
		lds[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if (arr[i] > arr[j]) {
					if (lds[j] > lds[i])
						lds[i] = lds[j];
				}
			}
			lds[i] += arr[i];
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, lis[i] + lds[i] - arr[i]);
		}
		System.out.println(max);
	}

}

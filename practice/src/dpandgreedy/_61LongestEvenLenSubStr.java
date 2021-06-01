package dpandgreedy;

import java.util.*;

public class _61LongestEvenLenSubStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void solution(int[] arr) {
		int[] sum = new int[arr.length + 1];

		sum[0] = 0;
		for (int i = 1; i < sum.length; i++) {
			sum[i] = arr[i - 1] + sum[i - 1];
		}

		int maxL = Integer.MIN_VALUE;
		for (int gap = 2; gap < sum.length; gap += 2) {
			for (int i = 0, j = i + gap; j < sum.length; i++, j++) {
				if (sum[i + gap / 2] - sum[i] == sum[j] - sum[i + gap / 2]) {
					if (gap > maxL) {
						maxL = gap;
					}
				}
			}
		}
		System.out.println(maxL);
	}

}

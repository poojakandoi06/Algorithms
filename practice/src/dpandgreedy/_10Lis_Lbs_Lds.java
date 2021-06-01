package dpandgreedy;

import java.util.*;

public class _10Lis_Lbs_Lds {

	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 55 ,70, 40, 30, 20 };
		lbs(arr, arr.length);

	}

	public static void lis(int[] arr, int n) {
		int[] dp = new int[n];
		int omax = 0;
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					if (dp[i] < dp[j]) {
						dp[i] = dp[j];
					}
				}
			}
			dp[i] += 1;
			omax = Math.max(omax, dp[i]);
		}
		System.out.println(omax);
	}

	public static void lds(int[] arr, int n) {
		int[] lds = new int[n];
		lds[0] = 1;
		int omax = 0;
		for(int i = 1; i < n; i++) {
			for(int j = 0 ; j < i; j++) {
				if(arr[j] > arr[i]) {
					if(lds[j] > lds[i]) {
						lds[i] = lds[j];
					}
				}
			}
			lds[i] += 1;
			omax = Math.max(omax, lds[i]);
		}
		System.out.println(omax);
	}

	public static void lbs(int[] arr, int n) {
		int omax = 0;
		
		int[] lis = new int[n];
		lis[0] = 1;
		for(int i = 1; i < n; i++) {
			for(int j = 0 ;j < i; j++) {
				if(arr[i] > arr[j]) {
					if(lis[j] > lis[i]) {
						lis[i] = lis[j];
					}
				}
			}
			lis[i] += 1;
		}
		
		int[] lds = new int[n];
		lds[n - 1] = 1;
		for(int i = n - 2; i >=  0; i--) {
			for(int j = n - 1 ; j > i; j--) {
				if(arr[j] < arr[i]) {
					if(lds[j] > lds[i]) {
						lds[i] = lds[j];
					}
				}
			}
			lds[i] += 1;
		}
		
		for(int i = 0 ; i < n; i++) {
			omax = Math.max(omax, lis[i] + lds[i] - 1);
		}
		
		System.out.println(omax);
	}

}

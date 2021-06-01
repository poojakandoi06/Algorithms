package dp;

import java.util.Arrays;

public class longest_biotonic_subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	public static int lbs(int[] arr) {
		int[] lis=lis(arr);
		int[] lds=lds(arr);
		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			max=Math.max(max,lis[i]+lds[i]-1);
		}
		return max;
	}
	public static int[] lis(int[] arr) {
		int[] dp=new int[arr.length];
		Arrays.fill(arr, 1);
		int max=1;
		for(int i=1;i<dp.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j] && dp[i]<dp[j]+1) {
					dp[i]=dp[j]+1;
					if(max<dp[i])
						max=dp[i];
				}
			}
		}
		return dp;
	}
	public static int[] lds(int[] arr) {
		int[] dp=new int[arr.length];
		Arrays.fill(arr, 1);
		int max=1;
		for(int i=dp.length-2;i>=0;i--) {
			for(int j=dp.length-1;j>i;j--) {
				if(arr[i]>arr[j] && dp[i]<dp[j]+1) {
					dp[i]=dp[j]+1;
					if(max<dp[i])
						max=dp[i];
				}
			}
		}
		return dp;
	}

}

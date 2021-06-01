package dp;

import java.util.Arrays;

public class min_deletion_to_make_sorted_sequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int mindel_tosortseq(int[] arr) {
		int lis=lis(arr);
		return arr.length-lis;
	}
	private static int lis(int[] arr) {
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
		return max;
	}

}

package atcoder_dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class O_matching {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int candy=s.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=s.nextInt();
		long[][] dp=new long[n][candy+1];
		for(int i=0;i<n;i++)
			Arrays.fill(dp[i], -1);
		System.out.println((int)ways(0,n,a,candy,dp));

	}
	public static long ways(int idx,int n, int[] a,int candy,long[][] dp) {
		if(candy<0)
			return 0;
		if(idx==n) {
			if(candy==0)
			return 1;
			else
			return  0;
		}
		if(dp[idx][candy]!=-1)
			return dp[idx][candy];
		
		int max=0;
		for(int i=0;i<=a[idx];i++) {
			if(candy-i>=0) {
			max+=ways(idx+1,n,a,candy-i,dp);
			}
		}
		max=max%1000000007;
		return dp[idx][candy]=max;
	}

}

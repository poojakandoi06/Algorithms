package dp;

import java.util.Arrays;

public class longest_palindromic_substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="babad";
		System.out.println(lpssubstring(str));

	}
	public static int lpssubstring(String str) {
		int n=str.length();
		boolean[][] dp=new boolean[n][n];
		int maxlength=1;
		for(int i=0;i<n;i++)
			dp[i][i]=true;
		
		int start=0;
		for(int i=0;i<n-1;i++) {
			if(str.charAt(i)==str.charAt(i+1)) {
				dp[i][i+1]=true;
				start=i;
				maxlength=2;
			}
		}
		for(int l=3;l<=n;++l) {
			for(int i=0;i<n-l+1;++i) {
				int j=l+i-1;
				if(dp[i+1][j-1] && str.charAt(i)==str.charAt(j))
					dp[i][j]=true;
				if(l>maxlength) {
					start=i;
					maxlength=l;
				}
			}
		}
		System.out.println(str.substring(start,start+maxlength));
		return maxlength;
	}

}

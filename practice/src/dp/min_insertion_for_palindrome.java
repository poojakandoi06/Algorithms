package dp;

public class min_insertion_for_palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int min_insertion(String str) {
		int n=str.length();
		int[][] dp=new int[n][n];
		
		for(int l=1;l<n;l++) {
			for(int i=0, j=l;j<n;i++,j++) {
			dp[i][j]=(str.charAt(i)==str.charAt(j))?dp[i+1][j-1]:Math.min(dp[i][j-1],dp[i+1][j]);	
			}
		}
		return dp[0][n-1];
	}
	
	//another approach
	// str.length()-[lcs(str,reverse(str))];

}

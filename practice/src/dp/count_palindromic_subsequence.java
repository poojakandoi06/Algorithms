package dp;

public class count_palindromic_subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int count(String str) {
	  int n=str.length();
	  int[][] dp=new int[n][n];
	  
	  for(int i=0;i<n;i++)
		  dp[i][i]=1;
	  
	  //gap strategy
	  for(int l=2;l<=n;l++) {
		  for(int i=0;i<n;i++) {
			  int j=l+i-1;
			  if(j<n) {
				  if(str.charAt(i)==str.charAt(j)) {
					  dp[i][j]=dp[i][j-1]+dp[i+1][j]+1;
				  }
				  else {
					  dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
				  }
			  }
		  }
	  }
	  return dp[0][n-1];
	}

}

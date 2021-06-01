package dp;

public class friends_pairing_problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static int pairrec(int n) {
    	if(n<=1)
    		return 1;
    	return pairrec(n-1)+pairrec(n-2)*(n-1);
    }
    public static int pairdp(int n) {
    	int[] dp=new int[n+1];
    	dp[0]=0;
    	dp[1]=1;
    	dp[2]=2;
    	for(int i=3;i<=n;i++) {
    		dp[i]=dp[i-1]+dp[i-2]*(i-1);
    	}
    	return dp[n];
    }
}

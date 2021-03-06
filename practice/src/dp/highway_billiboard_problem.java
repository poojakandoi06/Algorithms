package dp;

public class highway_billiboard_problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int placebillboard(int[] billboard,int[] revenue, int m, int t) {
		int n=revenue.length;
		int max=Integer.MIN_VALUE;
		// if n2>m we use miles method else use LIS
		// nlogn approach using treeset
		int[] dp=new int[m+1];
		int j=0;
		for(int i=1;i<=m;i++) {
			if(billboard[j]==i) {
				dp[i]=Math.max(dp[i-1], dp[i-t-1]+revenue[j]);
				j++;
			}
			else {
				dp[i]=dp[i-1];
			}
			if(dp[i]>max)
				max=dp[i];
		}
		return max;
	}

}

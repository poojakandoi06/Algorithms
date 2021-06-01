package dp;

public class unbounded_knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int solution(int[] weights, int[] prices, int capacity) {
		int[] dp=new int[capacity+1];
		dp[0]=0;
		for(int i=0;i<=capacity;i++) {
			for(int j=0;j<weights.length;j++) {
				if(weights[j]<=i) {
					dp[i]=Math.max(dp[i], dp[i-weights[j]]+prices[j]);
				}
			}
		}
		return dp[capacity];
	}

}

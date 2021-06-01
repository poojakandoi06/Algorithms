package dp;

public class gold_mine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int max_gold(int[][] gold) {
		int[][] dp = new int[gold.length + 2][gold[0].length];
		for (int j = gold[0].length - 2; j >= 0; j--) {
			for (int i = 1; i < dp.length - 2; i++) {
				dp[i][j]=Math.max(dp[i-1][j+1], Math.max(dp[i][j+1], dp[i+1][j+1]))+gold[i-1][j+1];
			}
		}
		int max=0;
		for(int i=0;i<dp.length;i++) {
			max=Math.max(dp[i][0], max);
		}
		return max;	
	}

}

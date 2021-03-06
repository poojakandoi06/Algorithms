package dp;

public class BuysellStocksWith_K_transac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 2; 
        int[] price = { 10, 22, 5, 75, 65, 80 }; 
        System.out.println("Maximum profit is: " +  
                            profit(price,  k)); 

	}
	public static int profit(int[] arr, int k) {
		int[][] dp = new int[k + 1][arr.length];
		for (int i = 0; i <=k; i++)
			dp[i][0] = 0;
		for (int i = 0; i <arr.length; i++)
			dp[0][i] = 0;
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <arr.length; j++) {
				int max_so_far = 0;
				for (int m = 0; m < j; m++) {
					max_so_far = Math.max(max_so_far, arr[j] - arr[m] + dp[i - 1][m]);
					dp[i][j] = Math.max(dp[i][j - 1], max_so_far);
				}
			}
		}
		return dp[k][arr.length-1];
	}
}

package dp;

public class Target_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3};
		int target=5;
		System.out.println(targetsum(arr,target));

	}
	public static boolean targetsum(int[] arr, int target) {
		boolean[][] dp=new boolean[arr.length+1][target+1];
		for(int i=0;i<dp.length;i++)
			dp[i][0]=true;
		for(int j=0;j<dp[0].length;j++)
			dp[0][j]=true;
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(arr[i-1]>j)
				dp[i][j]=dp[i-1][j];
				else {
					dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}

}

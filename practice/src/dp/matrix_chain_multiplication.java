package dp;

public class matrix_chain_multiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int matchainmulti(int[] nums) {
		int[][] dp=new int[nums.length][nums.length];
		for(int l=0;l<nums.length;l++) {
			for(int i=0;i<nums.length-l;i++) {
				int j=i+l;
				dp[i][j]=Integer.MAX_VALUE;
				for(int k=i+1;k<j;k++) {
					int q=dp[i][k]+dp[k][j]+nums[i]*nums[k]*nums[j];
					if(q<dp[i][j])
						dp[i][j]=q;
				}
			}
		}
		return dp[0][dp.length-1];
	}

}

package dp;

public class LinearEquationOf_n_variables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      // here coefficients are considered as coins and target is the right hand side value, apply coin change permutaion
	}
	public static int solveEquation(int[] arr, int target) {
		int[] dp=new int[target+1];
		dp[0]=1;
		for(int i=0;i<arr.length;i++) {
			for(int j=arr[i];j<target+1;j++) {
				dp[j]+=dp[j-arr[i]];
			}
		}
		return dp[target];
		//values can be found using arrayList same as in coin change
	}

}

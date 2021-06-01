package dp;

public class min_insertion_to_form_palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "geeks";
		System.out.println(func(str, 0, str.length() - 1));
		System.out.println(func(str));

	}

	// recursion
	public static int func(String str, int l, int h) {
		if (l > h) {
			return Integer.MAX_VALUE;
		}
		if (l == h) {
			return 0;
		}
		if(l==h-1) {
			return (str.charAt(l)==str.charAt(h))?0:1;
		}

		return (str.charAt(l) == str.charAt(h)) ? func(str, l + 1, h - 1) :

				Math.min(func(str, l, h - 1), func(str, l + 1, h)) + 1;

	}
	//dp Approach
	public static int func(String str) {
		int n=str.length();
		int[][] dp=new int[str.length()][str.length()];
		int l,h,gap;
		for(gap=1;gap<n;gap++) {
			for(l=0,h=gap;h<n;h++,l++) {
				dp[l][h]=(str.charAt(l)==str.charAt(h))?dp[l+1][h-1]:Math.min(dp[l+1][h], dp[l][h-1])+1;	
			}
		}
		return dp[0][n-1];
		
	}
	//can also be found using lcs .
	// n-lcs of string and its reverse gives the requireed answer.
}

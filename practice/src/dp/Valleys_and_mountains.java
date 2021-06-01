package dp;

public class Valleys_and_mountains {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// here number of n signifies pair of '/' and '\'
		// same catalen number is used for find bracket sequence given n as number of pair of bracket

	}
	public static int count(int n) {
		int res=0;
		if(n<=1)
			return 1;
		for(int i=0;i<n;i++) {
			res+=count(i)*count(n-i-1);
		}
		return res;
	}

}

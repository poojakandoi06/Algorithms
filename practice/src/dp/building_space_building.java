package dp;

public class building_space_building {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int building(int n) {
		int[] counts=new int[n+1];
		int[] countb=new int[n+1];
	    countb[0]=counts[0]=1;
	    for(int i=1;i<=n;i++) {
	    	countb[i]=counts[i-1];
	    	counts[i]=counts[i-1]+countb[i-1];
	    }
	    int ans=countb[n]+counts[n];
	    return ans*ans;
	}

}

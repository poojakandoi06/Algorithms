package dp;

public class chords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// given 2n points tell how many non-overlapping chords can be made

	}
	public static int chords(int n) {
		int[] res=new int[n+2];
		res[0]=1;
		res[1]=1;
		for(int i=2;i<=n;i++) {
			res[i]=0;
			for(int j=0;i<i;j++) {
				res[i]+=res[j]*res[i-j-1];
			}
		}
		return res[n];
	}

}

package dp;

public class max_sum_subsequence_without_adjacent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {5,5,10,100,10,5};
		System.out.println(msswa(arr));

	}
	public static int msswa(int[] arr) {
		int[] inc=new int[arr.length];
		int[] exc=new int[arr.length];
		inc[0]=arr[0];
		exc[0]=0;
		for(int i=1;i<arr.length;i++) {
			int exec=Math.max(inc[i-1], exc[i-1]);
				inc[i]=exc[i-1]+arr[i];
				exc[i]=exec;
			
		}
		return Math.max(inc[arr.length-1],exc[arr.length-1]);
	}

}

package dp;

public class BuysellStocks_2_transac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int profit(int[] arr) {  // atmost 2 transac
		int[] min=new int[arr.length];
		int[] max=new int[arr.length];
		int minn=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<minn)
				minn=arr[i];
			min[i]=arr[i]-minn;
			
		}
		int maxx=arr[arr.length-1];
		for(int i=arr.length-2;i>=0;i++) {
			if(arr[i]>maxx)
				maxx=arr[i];
			max[i]=maxx-arr[i];
		}
		int ans=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++)
			ans=Math.max(ans,min[i]+max[i]);
		
		return ans;
	}
	

}

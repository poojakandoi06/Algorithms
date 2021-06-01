package dp;

public class BuySellStocksWith_1_transaction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int profit(int[] arr) {
		int[] min=new int[arr.length]; //minimum element
		int[] max=new int[arr.length]; // max profit
		for(int i=1;i<arr.length;i++) {
			min[i]=Math.min(min[i-1],arr[i]);
			max[i]=Math.max(max[i-1],arr[i]-min[i]);
		}
		return max[arr.length-1];
	}

}

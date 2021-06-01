package dp;

public class buy_sell_stocks_infinite_times {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int max_profit(int[] arr) {
		int max=Integer.MIN_VALUE;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>arr[i-1])
				max+=(arr[i]-arr[i-1]);
		}
		return max;
	}

}

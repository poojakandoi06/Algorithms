package dpandgreedy;
import java.util.*;

public class _30JobSequencing {

	public static class pair implements Comparable<pair> {
		Character id;
		int deadline;
		int profit;

		public pair(Character id, int deadline, int profit) {
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return o.profit - this.profit;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		pair[] arr = new pair[5];
		arr[0] = new pair('a', 2, 100);
		arr[1] = new pair('b', 1, 19);
		arr[2] = new pair('c', 2, 27);
		arr[3] = new pair('d', 1, 25);
		arr[4] = new pair('e', 3, 15);
		solution(arr);

	}

	public static void solution(pair[] arr) {

		Arrays.sort(arr);

		int max = arr[0].deadline;
		for (int i = 1; i < arr.length; i++) {
			max = Math.max(max, arr[i].deadline);
		}

		int[] ans = new int[max + 1];
		int profit = 0;
		for (int i = 0; i < arr.length; i++) {

			int index = arr[i].deadline;
			while (ans[index] != 0 && index >= 1) {
				index--;

			}

			if (index >= 1) {
				ans[index] = arr[i].profit;
				profit += arr[i].profit;
			}
		}

		System.out.println(profit);

	}

}

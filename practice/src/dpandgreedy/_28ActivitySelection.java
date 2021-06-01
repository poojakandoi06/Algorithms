package dpandgreedy;

import java.util.*;

public class _28ActivitySelection {

	public static class pair implements Comparable<pair> {
		int start;
		int end;

		pair(int s, int e) {
			this.start = s;
			this.end = e;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.end - o.end;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		pair[] arr = new pair[6];
		arr[0] = new pair(0, 6);
		arr[1] = new pair(1, 2);
		arr[2] = new pair(5, 7);
		arr[3] = new pair(3, 4);
		arr[4] = new pair(8, 9);
		arr[5] = new pair(5, 9);
		solution(arr);

	}

	public static void solution(pair[] arr) {

		Arrays.sort(arr);
		int ans = 1;
		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[j].start > arr[i].end) {
					i = j - 1;
					ans++;
					break;
				}

			}

		}

		System.out.println(ans);

	}

}

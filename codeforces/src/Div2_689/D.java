package Div2_689;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class D {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int q = s.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < n; i++)
				arr[i] = s.nextInt();
			Arrays.sort(arr);
			HashSet<Long> set = new HashSet<>();
			long[] sum = new long[n];
			for (int i = 0; i < n; i++) {
				if (i > 0)
					sum[i] = sum[i - 1] + arr[i];
				else
					sum[i] = (long)arr[i];
			}
			TreeMap<Integer, Integer> map = new TreeMap<>();
			for (int i = 0; i < n; i++)
				map.put(arr[i], i);
			dfs(0, n - 1, sum, arr, set, map);

			while (q-- > 0) {
				long si = s.nextLong();
				if (set.contains(si)) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
		}

		out.close();
	}

	public static void dfs(int i, int j, long[] sum, int[] arr, HashSet<Long> set, TreeMap<Integer, Integer> map) {
		if (i < 0 || j >= arr.length)
			return;
		if (i == j) {
			set.add((long)arr[i]);
			return;
		}
		long ss = sum[j] - ((i == 0) ? 0 : sum[i - 1]);
		set.add(ss);
		int mid = (arr[i] + arr[j]) / 2;
		int index = -1;
		for (int k = i; k <= j; k++) {
			if (arr[k] <= mid)
				index = k;
		}
		if (index == -1 || index < i || index >= j)
			return;
		dfs(i, index, sum, arr, set, map);
		dfs(index + 1, j, sum, arr, set, map);

	}

	public static PrintWriter out;

	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}

}

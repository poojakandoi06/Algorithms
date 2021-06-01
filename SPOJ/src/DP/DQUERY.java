package DP;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class DQUERY {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = s.nextInt();

		int q = s.nextInt();
		int[][] qr = new int[q][3];
		for (int i = 0; i < q; i++) {

			qr[i][0] = s.nextInt() - 1;
			qr[i][1] = s.nextInt() - 1;
			qr[i][2]=i;
		}
		Arrays.sort(qr, (a, b) -> (a[1] == b[1])?a[0]-b[0]:a[1]-b[1]);
		int[] bit = new int[n + 1];
		int[] lo = new int[1000000 + 1];
		int[] res = new int[q];
		Arrays.fill(lo, -1);
		int index = 0;
		for (int i = 0; i < n; i++) {
			int num = arr[i];
			if (lo[num] != -1) {
				int id = lo[num];
				update(bit, id + 1, -1);
			}
			lo[num] = i;
			update(bit, i + 1, 1);
			while (index<q && i == qr[index][1]) {
				res[qr[index][2]] = get(bit, i + 1) - get(bit, qr[index][0]);
				index++;
			}
		}

		for (int i = 0; i < q; i++) {
			out.println(res[i]);
		}

		out.close();
	}

	public static void update(int[] bit, int i, int val) {
		while (i < bit.length) {
			bit[i] += val;
			i += i & -i;
		}
	}

	public static int get(int[] bit, int i) {
		int sum = 0;
		while (i > 0) {
			sum += bit[i];
			i -= i & -i;
		}
		return sum;
	}

	public static void update(HashMap<Integer, Integer>[] bit, int i, int val) {
		while (i < bit.length) {
			bit[i].put(val, bit[i].getOrDefault(val, 0) + 1);
			i += (i & -i);
		}

	}

	public static HashMap<Integer, Integer> get(HashMap<Integer, Integer>[] bit, int i) {
		HashMap<Integer, Integer> map = new HashMap<>();
		while (i > 0) {
			for (int j : bit[i].keySet()) {
				map.put(j, map.getOrDefault(j, 0) + bit[i].get(j));
			}
			i -= (i & -i);
		}
		return map;
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

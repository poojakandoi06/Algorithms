package DP;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MATSUM {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int[][] bit = new int[n + 1][n + 1];
			int[][] arr = new int[n][n];
			while (true) {
				String[] str = s.nextLine().split(" ");
				if (str[0].equals("END"))
					break;

				if (str[0].equals("SET")) {
					int x = Integer.valueOf(str[1]);
					int y = Integer.valueOf(str[2]);
					int val = Integer.valueOf(str[3]);
					int toremove = arr[x][y];
					arr[x][y] = val;
					update(bit, x + 1, y + 1, val - toremove);
				} else {
					int x1 = Integer.valueOf(str[1]) + 1;
					int y1 = Integer.valueOf(str[2]) + 1;
					int x2 = Integer.valueOf(str[3]) + 1;
					int y2 = Integer.valueOf(str[4]) + 1;
					int sum = get(bit, x2, y2) - get(bit, x2, y1 - 1) - get(bit, x1 - 1, y2) + get(bit, x1 - 1, y1 - 1);
					out.println(sum);
				}
			}
		}

		out.close();
	}

	public static void update(int[][] bit, int x, int y, int val) {
		for (; x < bit.length; x += (x & -x)) {
			int i = y;
			for (; i < bit[x].length; i += i & -i) {
				bit[x][i] += val;

			}
		}
	}

	public static int get(int[][] bit, int x, int y) {
		int sum = 0;
		for (; x > 0; x -= (x & -x)) {
			int i = y;
			for (; i > 0; i -= i & -i) {
				sum += bit[x][i];

			}
		}

		return sum;
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

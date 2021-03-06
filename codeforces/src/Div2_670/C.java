package Div2_670;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			ArrayList<Integer>[] list = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++)
				list[i] = new ArrayList<Integer>();
			for (int i = 1; i < n; i++) {
				int x = s.nextInt();
				int y = s.nextInt();
				list[x].add(y);
				list[y].add(x);

			}
			int[] mdown = new int[n + 1];
			int[] total = new int[n + 1];
			dfs(1, list, -1, total, mdown, n);
			int v1 = -1;
			int v2 = -1;
			int c = Integer.MAX_VALUE;
			for (int i = 1; i <= n; i++) {
				if (c > mdown[i]) {
					c = mdown[i];
					v1 = i;
					v2 = -1;
				} else if (c == mdown[i]) {
					v2 = i;
				}
			}
			if (v2 == -1) {
				out.println(v1 + " " + list[v1].get(0));
				out.println(v1 + " " + list[v1].get(0));
			} else {
				for (int j = 0; j < list[v1].size(); j++) {
					int v = list[v1].get(j);
					if (v != v2) {
						out.println(v1 + " " + v);
						out.println(v2 + " " + v);
						break;
					}
				}
			}

		}

		out.close();
	}

	public static void dfs(int i, ArrayList<Integer>[] list, int prev, int[] size, int[] mdown, int n) {
		size[i] = 1;
		for (int j = 0; j < list[i].size(); j++) {
			int v = list[i].get(j);
			if (v == prev)
				continue;
			dfs(v, list, i, size, mdown, n);
			size[i] += size[v];
			mdown[i] = Math.max(mdown[i], size[v]);

		}
		mdown[i] = Math.max(mdown[i], n - size[i]);
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

	public static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String nextToken() {
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
			return Integer.parseInt(nextToken());
		}

		long nextLong() {
			return Long.parseLong(nextToken());
		}

		double nextDouble() {
			return Double.parseDouble(nextToken());
		}

	}

}

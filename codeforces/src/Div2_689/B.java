package Div2_689;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int m = s.nextInt();
			int[][] arr = new int[n][m];
			int[][] sum = new int[n][m];
			for (int i = 0; i < n; i++) {
				String str = s.next();
				for (int j = 0; j < m; j++) {
					if (str.charAt(j) == '.')
						arr[i][j] = 0;
					else
						arr[i][j] = 1;
					if(j>0)
					sum[i][j] = sum[i][j-1] + arr[i][j];
					else
						sum[i][j]=arr[i][j];
				}
			}

			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 1) {
						int k = i;
						int t1 = 0;
							while (k < n && j + t1 < m && j - t1>= 0
									&& sum[k][j + t1] - (j-t1==0?0:sum[k][j - t1 - 1]) == (2 * t1 + 1)) {
								k++;
								t1++;
							}
						//System.out.println(i+" "+j+" "+(t1));
						count += (t1);
					}
				}
			}
			out.println(count);

		}

		out.close();
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

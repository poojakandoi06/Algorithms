package December_long_2020;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class POSPREFS {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int k = s.nextInt();

			int[] arr = new int[n];
			if (k <= (n - k)) {
				for (int i = 0; i < n; i++) {
					if (k > 0) {
						if (i % 2 == 0) {
							arr[i] = i + 1;
							k--;
						} else
							arr[i] = -i - 1;

					} else {
						arr[i] = -i - 1;
					}
				}

			} else {
				k = n - k;
				for (int i = 0; i < n; i++) {
					if (k > 0) {
						if (i % 2 == 0) {
							arr[i] = -i - 1;
							k--;
						} else
							arr[i] = i + 1;

					} else {
						arr[i] = i + 1;
					}
				}
				
			}

			
			for (int i = 0; i < n; i++) {
				out.print(arr[i] + " ");
			}
			out.println();

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

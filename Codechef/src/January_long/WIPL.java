package January_long;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WIPL {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int k = s.nextInt();
			int[] h = new int[n];
			for (int i = 0; i < n; i++)
				h[i] = s.nextInt();
			Arrays.sort(h);
			for(int i=0;i<n;i++) {
				out.print(h[i]+" ");
			}
			out.println();
			int s1 = 0;
			int s2 = 0;
			int i = n - 1;
			for (i = n - 1; i >= 0; i--) {
				if(s1<k && s2<k)
				{
					if(s1<=s2) {
						s1+=h[i];
					}
					else {
						s2+=h[i];
					}
					out.println(1+" "+s1+" "+s2);
				}
				else if(s1<k) {
					s1+=h[i];
					out.println(2+" "+s1+" "+s2);
				}
				else if(s2<k) {
					s2+=h[i];
					out.println(3+" "+s1+" "+s2);
				}
				else {
					out.println(s1+" "+s2);
					break;
				}

			}
			
			out.println(n-i-1);
		}
		out.close();
	}

	public static long dfs(int k, int[] h, int i, int s1, int s2, long[][][] dp) {
		if (i < 0) {
			if (s1 >= k && s2 >= k) {
				return (h.length - i + 1);
			} else {
				return Integer.MAX_VALUE;
			}
		}
		if (s1 > 4000)
			s1 = 4001;
		if (s2 > 4000)
			s2 = 4001;
		if (dp[i][s1][s2] != -1) {
			return dp[i][s1][s2];
		}
		if (s1 >= k && s2 >= k) {
			dp[i][s1][s2] = (h.length - i - 1);
			return (h.length - i - 1);
		} else {
			long min = Integer.MAX_VALUE;
			if (s1 < k)
				min = Math.min(min, dfs(k, h, i - 1, s1 + h[i], s2, dp));
			if (s2 < k)
				min = Math.min(min, dfs(k, h, i - 1, s1, s2 + h[i], dp));
			dp[i][s1][s2] = min;
			return min;
		}

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

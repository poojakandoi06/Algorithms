package Div2_685;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int q = s.nextInt();
			String str = s.next();
			int[][] zer=new int[n][2];
			
			while (q-- > 0) {
				int l = s.nextInt()-1;
				int r = s.nextInt()-1;
				
				if(l==r) {
					out.println("NO");
					continue;
				}
				
//				int[][] dp=new int[n+1][sub.length()+1];
//				for(int i=0;i<=n;i++)
//					Arrays.fill(dp[i], 0);
//				boolean res=dfs(str,sub,0,0,false,dp);
				boolean res=false;
				if(l!=0) {
					char c=str.charAt(l);
					l--;
					while(l>=0) {
						if(str.charAt(l)==c) {
							res=true;
							break;
						}
						l--;
					}
				}
				if(r!=n-1) {
					char c=str.charAt(r);
					r++;
					while(r<n) {
						if(str.charAt(r)==c) {
							res=true;
							break;
						}
						r++;
					}
				}
				
				if (res == true) {
					out.println("YES");
				} else {
					out.println("NO");
				}
			}
		}

		out.close();
	}

	public static boolean dfs(String str, String sub, int i, int j, boolean found, int[][] dp) {
		if (i >= str.length() && j != sub.length())
			return false;
		if (j == sub.length()) {
			if (found == true)
				return true;
			else
				return false;
		}
		if (dp[i][j] != 0) {
			if (dp[i][j] == 1)
				return true;
			else
				return false;
		}
		boolean res = false;

		if (str.charAt(i) == sub.charAt(j)) {
			res |= dfs(str, sub, i + 1, j + 1, found, dp);
		}
		res |= dfs(str, sub, i + 1, j, true, dp);
		dp[i][j] = res == true ? 1 : -1;
		return res;

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

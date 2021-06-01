package cookOff_October;

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

public class PATHSUMS {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			ArrayList<Integer>[] list = new ArrayList[n];
			for (int i = 0; i < n; i++)
				list[i] = new ArrayList<Integer>();
			int[] res = new int[n];
			for (int i = 0; i < n - 1; i++) {
				int a = s.nextInt() - 1;
				int b = s.nextInt() - 1;
				list[a].add(b);
				list[b].add(a);
			}
			Arrays.fill(res, -1);
			dfs(0, list, res, 2);
			for(int i=0;i<n;i++) {
				System.out.print(res[i]+" ");
			}
			System.out.println();

		}

		out.close();
	}

	private static void dfs(int node, ArrayList<Integer>[] list, int[] res, int oddeven) {
		if(res[node]!=-1)
			return ;
		if(oddeven%2==0) {
			res[node]=2;
			for(int i=0;i<list[node].size();i++) {
				dfs(list[node].get(i),list,res,1);
			}
		}
		else {
			res[node]=1;
			for(int i=0;i<list[node].size();i++) {
				dfs(list[node].get(i),list,res,2);
			}
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

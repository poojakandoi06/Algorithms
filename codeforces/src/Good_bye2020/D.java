package Good_bye2020;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			long sum = 0;
			long[] w = new long[n];
			for (int i = 0; i < n; i++) {
				w[i] = s.nextLong();
				sum += w[i];
			}
			int[] edge = new int[n];
			PriorityQueue<Long> pq=new PriorityQueue<Long>(Collections.reverseOrder());
			for (int i = 0; i < n - 1; i++) {
				int u = s.nextInt() - 1;
				int v = s.nextInt() - 1;
				if(edge[u]!=0)
					pq.add(w[u]);
				if(edge[v]!=0)
					pq.add(w[v]);
				
				edge[u]++;
				edge[v]++;
			}
			
			long[] res = new long[n - 1];
			res[0]=sum;
			for (int i = 1; i < res.length; i++) {
				sum+=pq.remove();
				res[i]=sum;
			}
			for (int i = 0; i < n - 1; i++)
				out.print(res[i] + " ");
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

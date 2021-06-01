package september_LongChallenge;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CRDGAME2 {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			int max = 0;
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == max)
					count++;
				else if(arr[i]>max) {
					max=arr[i];
					count=1;
				}
			}
			int first=count/2+1;
			long res=0;
			long rem=(long)Math.pow(2,n-count);
			//System.out.println(rem);
			for(int i=first;i<=count;i++) {
				long val=ncr(count,i);
				//System.out.println(val+" "+count+" "+i);
				res+=val;
			}
			res = 2 * res*rem;
			res = res % 1000000007;
			System.out.println(res);
		}

		out.close();
	}
	public static long ncr(int n, int r) {
		long rem=n-r;
		long res=1;
		for(int i=n;i>r;i--) {
			res=res*i;
		}
		for(long i=rem;i>=1;i--) {
			res=res/i;
		}
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

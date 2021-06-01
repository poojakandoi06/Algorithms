package september_LongChallenge;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

class test {
	static int res;
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			long sum1 = n * (n + 1) / 2;
			if (sum1 % 2 == 1) {
				out.println(0);
				continue;
			}
			res = 0;
			b1(1, n, sum1, n);
			long count = 0;
			while (res >= 0) {
				int i = res--;
				long sum = i * (i + 1) / 2;
				long backsum = sum1 - sum;
				if (backsum != sum) {
					long val = backsum - sum;
					if (val % 2 == 1) {
						continue;
					} else {
						long right = i + val / 2;
						long left = i;
						if (right > n) {
							left = i - (right - n);
							right = n;

						}

						long value = Math.max(0, Math.min(left, right - i));
						if (value == 0)
							break;
						count += value;
					}
				}
				if (backsum == sum) {
					long left = i;
					long right = n - i;
					long back = (left <= 1) ? 0 : (left * (left - 1) / 2);
					long front = (right <= 1) ? 0 : (right * (right - 1) / 2);
					count += back + front;
				}
			}
			out.println(count);
		}
		

		out.close();
	}

	public static void b1(int l, int r, long sum1, int n) {
		if (l > r)
			return;
		int i = (l + r) / 2;
		long sum = i * (i + 1) / 2;
		long backsum = sum1 - sum;
		if (backsum > sum) {
			l = i + 1;
			res = i;
			b1(l, r, sum1, n);
		} else if (backsum == sum) {
			res = i;
			return;
		} else {
			r = i - 1;
			b1(l, r, sum1, n);
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

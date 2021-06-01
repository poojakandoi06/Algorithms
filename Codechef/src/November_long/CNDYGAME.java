package November_long;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CNDYGAME {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = s.nextInt();
		while (t-- > 0) {
			long mod = 1000000007l;
			int n = s.nextInt();
			long[] a = new long[n + 1];
			long[] prev = new long[n + 1];
			for (int i = 1; i <= n; i++) {
				a[i] = s.nextLong();
			}
			int q = s.nextInt();
			if (a[1] == 1) {
				while (q-- > 0) {
					long r = s.nextLong();
					if (r <= n) {
						out.println(1);
					} else {
						long temp = (r / n);
						long ans = temp % mod;
						long rem = r % n;
						if (rem > 1) {
							ans++;
						}
						out.println(ans % mod);

					}
				}
			} else if (a[n] == 1) {
				long chef = 0;
				for (int i = 1; i < n; i++) {
					if (a[i] % 2 != 0)
						chef += a[i] - 1;
					else
						chef += a[i];
					prev[i] = chef;
				}
				chef += 1;
				prev[n] = chef;
				while (q-- > 0) {
					long r = s.nextLong();
					long temp = r / n;
					long ans = (temp % mod) * (chef % mod) % mod;
					if (r % n != 0)
						ans += prev[(int) r % n - 1] + a[(int) r % n];
					out.println(ans % mod);

				}

			} else {
				int next = 0;
				long chef = 0;
				for (int i = 1; i < n; i++) {
					next = i + 1;
					if (a[next] != 1) {
						if (a[i] % 2 == 1)
							chef += a[i] - 1;
						else
							chef += a[i];
						prev[i] = chef;
					} else {
						if (a[i] % 2 == 1)
							chef += a[i];
						else
							chef += a[i] - 1;
						prev[i] = chef;
						i++;
						prev[i] = chef;
					}
				}
				if (a[n] % 2 == 1)
					chef += a[n];
				else
					chef += a[n] - 1;
				prev[n] = chef;

				while (q-- > 0) {
					long r = s.nextLong();
					long temp = r / n;
					long ans = ((temp % mod) * (chef % mod)) % mod;
					if (r % n == 0) {
						if (a[n] % 2 == 0)
							ans++;
					} else {
						if (a[(int) r % n] == 1) {
							if (a[(int) r % n - 1] % 2 == 1)
								ans += prev[(int) r % n];
							else
								ans += prev[(int) r % n] + 2;
						} else {
							ans += prev[(int) r % n - 1] + a[(int) r % n];
						}
					}
					out.println(ans % mod);
				}
			}
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

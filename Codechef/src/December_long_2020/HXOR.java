package December_long_2020;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HXOR {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int[] arr = new int[n];
			int x = s.nextInt();
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			ArrayList<Integer>[] bits = new ArrayList[32];
			for (int i = 0; i < bits.length; i++)
				bits[i] = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 32; j++) {
					if ((arr[i] & (1 << j)) != 0) {
						bits[j].add(i);
					}
				}
			}
			boolean found=false;
			int[] index = new int[32];
			for (int i = 0; i < n - 1; i++) {
				for (int j = 31; j >= 0; j--) {
					if (x > 0) {
						if (bits[j].size() > 0 && index[j] < bits[j].size() && bits[j].get(index[j]) == i) {
							if (index[j] < (bits[j].size() - 1)) {
								arr[i] = arr[i] ^ (1 << j);
								int b = bits[j].get(index[j] + 1);
								arr[b] = arr[b] ^ (1 << j);
								index[j] += 2;
								found=true;
								x--;
							} else if (index[j] < bits[j].size()) {
								arr[i] = arr[i] ^ (1 << j);
								arr[n - 1] = arr[n - 1] ^ (1 << j);
								index[j]++;
								found=true;
								x--;
							}
						}
					} else
						break;
				}

			}
				if (x==1 || (x%2==1 && n<=2)) {
					arr[n - 1] ^= (1<<32);
					arr[n - 2] ^= (1<<32);

				}
				
				
			

			for (int i = 0; i < n; i++)
				out.print(arr[i] + " ");
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

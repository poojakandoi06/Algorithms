package November_long;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class FEMA2 {
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = s.nextInt();
		while (t-- > 0) {
			long n = s.nextLong();
			long k = s.nextLong();
			k++;
			long count = 0;
			TreeMap<Long, Long> mag = new TreeMap<>();
			TreeMap<Long, Long> iron = new TreeMap<>();
			String str = s.next();
			int sheets = 0;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == ':')
					sheets++;
				else {
					long num = i + sheets; 
					if (c == 'I') {
						if (mag.ceilingKey(num - k + 1) != null) {
							count++;
							long key = mag.ceilingKey(num - k + 1);
							mag.put(key, mag.get(key) - 1);
							if (mag.get(key) == 0)
								mag.remove(key);
						} else {
							iron.put(num, iron.getOrDefault(num,(long)0) + 1);
						}
					} else if (c == 'M') {
						if (iron.ceilingKey(num - k + 1) != null) {
							count++;
							long key = iron.ceilingKey(num - k + 1);
							iron.put(key, iron.get(key) - 1);
							if (iron.get(key) == 0)
								iron.remove(key);
						} else
							mag.put(num, mag.getOrDefault(num, (long) 0) + 1);
					} else if (c == 'X') {
						iron=new TreeMap<>();
						mag=new TreeMap<>();
					}	
				}
				

			}
			System.out.println(count);
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

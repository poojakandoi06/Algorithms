import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class class1 {
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

	public static PrintWriter out;
	public static MyScanner s;

	public static void main(String[] args) {
		s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// Weird_algorithm();
		// missing_number();
		// repetitions();
		//increasing_array();
		//number_spiral();
		out.close();
	}
	
	private static void number_spiral() {
		int n=s.nextInt();
		while(n-->0) {
			int r=s.nextInt();
			int c=s.nextInt();
			
		}
		
	}

	private static void increasing_array() {
		int n = s.nextInt();
		long[] arr = new long[n];
		long count = 0;
		long prev=0;
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextLong();
			if(i==0)
				prev=arr[i];
			if (i != 0) {
				count += (arr[i] >prev) ? 0 : prev - arr[i];
				if(arr[i]>prev)
					prev=arr[i];
			}
		}
		out.println(count);

	}

	public static void repetitions() {
		String str = s.next();
		if (str.equals("")) {
			out.println(0);
			return;
		}
		long res = 1;
		long count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				count++;
			} else {
				res = Math.max(res, count);
				count = 1;
			}
		}
		res = Math.max(res, count);
		out.println(res);

	}

	public static void missing_number() {
		long n = s.nextLong();
		long sum = 0;
		for (int i = 1; i < n; i++) {
			sum += s.nextInt();
		}
		long missing_number = n * (n + 1) / 2 - sum;
		out.println(missing_number);
	}

	public static void Weird_algorithm() {

		long n = s.nextLong();
		while (n != 1) {
			out.print(n + " ");
			if ((n & 1) == 0)
				n = n / 2;
			else
				n = n * 3 + 1;
		}
		out.print(1);
	}

}

package cookOff_november;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class HIRINGWO {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = s.nextInt();
		while (t-- > 0) {
			long k = s.nextLong();
			long x = s.nextLong();
			long res = find(x, k);
			out.println(res);
		}
		out.close();
	}

	public static long find(long x, long k) {
		ArrayList<Long> prime = new ArrayList<Long>();
		TreeMap<Long,Long> map=new TreeMap<>();
		long n = x;
		long count = 0;
		while (x % 2 == 0) {
			count++;
			x = x / 2;
		}
		
		if (count > 0) {
			prime.add((long)2);
			map.put((long)2,count-1);
		}
		for (long i = 3; i * i <= x; i += 2) {
			count = 0;
			while (x % i == 0) {
				count++;
				x = x / i;
			}
			if (count > 0) {
				map.put(i,count-1);
				prime.add((long)i);
			}
		}
		if (x > 2) {
			prime.add(x);
		}

		int size = prime.size();

		
			PriorityQueue<Long> pq = new PriorityQueue<Long>();
				for(long j:map.keySet()) {
					long len=map.get(j);
					while(len-->0)
					pq.add(j);
				}
			
			while (pq.size() > (k-prime.size())) {
				long a = pq.poll();
				long b = pq.poll();
				pq.add(a * b);
			}
			long ss = 0;
			for(long i:prime) 
				pq.add(i);
				while (pq.size() > k) {
					long a = pq.poll();
					long b = pq.poll();
					pq.add(a * b);
				}
			
				if(pq.size()<k) {
					ss+=(k-pq.size());
				}
			while (pq.size() > 0) {
				ss += pq.poll();
			}
			
			return ss;
		
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

package Div3_667;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class E {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = s.nextInt();
		StringBuilder sb=new StringBuilder();
		while (t-- > 0) {
			int n=s.nextInt();
			int k=s.nextInt();
			int[] x=new int[n];
			int[] y=new int[n];
			TreeMap<Integer,Integer> map=new TreeMap<>();
			for(int i=0;i<n;i++) {
				x[i]=s.nextInt();
				map.put(x[i],map.getOrDefault(x[i], 0)+1);
			}
			for(int i=0;i<n;i++) {
				y[i]=s.nextInt();
			}
			int[] arr=new int[map.size()];
			int[] num=new int[map.size()];
			
			int idx=0;
			for(int i:map.keySet()) {
				
				arr[idx]=i;
				num[idx]=map.get(i);
				idx++;
			}
			int[] prevsum=new int[arr.length];
			prevsum[0]=num[0];
			for(int i=1;i<arr.length;i++) {
				prevsum[i]=prevsum[i-1]+num[i];
			}
			int[] maxleft=new int[arr.length];
			TreeMap<Integer,Integer> map2=new TreeMap<>();
			for(int i=0;i<arr.length;i++) {
				map2.put(arr[i],i);
			}
			maxleft[0]=num[0];
			for(int i=1;i<arr.length;i++) {
				maxleft[i]=num[i];
				if(map2.ceilingKey(arr[i]-k)!=null) {
					if(map2.get(map2.ceilingKey(arr[i]-k))==0)
					maxleft[i]=Math.max(maxleft[i], prevsum[i]);
					else
					maxleft[i]=Math.max(maxleft[i], prevsum[i]-prevsum[map2.get(map2.ceilingKey(arr[i]-k))-1]);
				}
				if(i>0)
				maxleft[i]=Math.max(maxleft[i],maxleft[i-1]);
					
			}
			int[] maxright=new int[arr.length];
			maxright[arr.length-1]=num[arr.length-1];
			for(int i=arr.length-2;i>=0;i--) {
				maxright[i]=num[i];
				if(map2.floorKey(arr[i]+k)!=null) {
					if(i==0) {
						maxright[i]=Math.max(maxright[i], prevsum[map2.get(map2.floorKey(arr[i]+k))]);
					}
					else {
						maxright[i]=Math.max(maxright[i], prevsum[map2.get(map2.floorKey(arr[i]+k))]-prevsum[i-1]);
					}
				}
				if(i<arr.length-1)
					maxright[i]=Math.max(maxright[i],maxright[i+1]);
			}
//			for(int i=0;i<arr.length;i++) {
//				System.out.print(arr[i]+" ");
//			}
//			System.out.println();
//			for(int i=0;i<arr.length;i++) {
//				System.out.print(num[i]+" ");
//			}
//			System.out.println();
//			for(int i=0;i<arr.length;i++) {
//				System.out.print(maxleft[i]+" ");
//			}
//			System.out.println();
//			for(int i=0;i<arr.length;i++) {
//				System.out.print(maxright[i]+" ");
//			}
			
			int max=0;
			if(arr.length==1)
				max=maxleft[0];
			for(int i=1;i<arr.length;i++) {
				max=Math.max(maxleft[i-1]+maxright[i],max);
			}
			sb.append(max+"\n");
			
			
		}
		out.println(sb.toString());
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

package practice_Random;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class D1446 {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int n=s.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=s.nextInt();
		}
		HashMap<Integer,Integer> freq=new HashMap<>();
		HashMap<Integer,int[]> index=new HashMap<Integer,int[]>();
		int maxfreq=0;
		for(int i=0;i<n;i++) {
			freq.put(arr[i],freq.getOrDefault(arr[i], 0)+1);
			if(!index.containsKey(arr[i])) {
				index.put(arr[i],new int[] {i,i});
			}
			else {
				index.get(arr[i])[1]=i;
			}
			maxfreq=Math.max(maxfreq, freq.get(arr[i]));
		}
		TreeMap<Integer,ArrayList<Integer>> map=new TreeMap<>();
		for(int i:freq.keySet()) {
			if(!map.containsKey(freq.get(i))) {
				map.put(freq.get(i),new ArrayList<Integer>());
			}
			map.get(freq.get(i)).add(i);
		}
		if(map.get(maxfreq).size()>1) {
			out.println(n);
		}
		else {
			if(map.size()==1) {
				out.println("0");
				
			}
			else {
			
			int c1=map.get(maxfreq).get(0);
			map.remove(maxfreq);
			int max=0;
			for(int j=0;j<map.get(map.lastKey()).size();j++) {
				int maxm=0;
			int c2=map.get(map.lastKey()).get(j);
			int[] ar=new int[n];
			for(int i=0;i<n;i++) {
				if(arr[i]==c1)
					ar[i]=1;
				else if(arr[i]==c2)
					ar[i]=-1;
				else
					ar[i]=0;
			}
		
			HashMap<Integer,Integer> mm=new HashMap<>();
			mm.put(0,-1);
			int prev=0;
			for(int i=0;i<n;i++) {
				prev+=ar[i];
				if(mm.containsKey(prev)) {
					maxm=Math.max(maxm, i-mm.get(prev));
				}
				else {
					mm.put(prev,i);
				}
			}
			max=Math.max(max, maxm);
			}
			out.println(max);
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

package Lunchtime_Aug;

import java.util.Scanner;
import java.util.TreeMap;

public class MODEFREQ {

	public static void main(String[] args) {
		try {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
			int n=s.nextInt();
			TreeMap<Integer,Integer> map=new TreeMap<>();
			int[] arr=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=s.nextInt();
				map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			}
			TreeMap<Integer,Integer> map2=new TreeMap<>();
			for(int i:map.keySet()) {
				map2.put(map.get(i),map2.getOrDefault(map.get(i), 0)+1);
			}
			int max=0;
			int num=0;
			for(int i:map2.keySet()) {
				int frq=i;
				int count=map2.get(i);
				if(count>max) {
					max=count;
					num=frq;
				}
			}
			System.out.println(num);
			
		}
		}catch(Exception e) {
			return;
		}

	}

}

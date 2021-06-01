package Div2_666;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D {
	// the current player will always choose the maximum pile of coin available to him

	public static void main(String[] args) {
		try {
			Scanner s=new Scanner(System.in);
			int t=s.nextInt();
			StringBuilder sb=new StringBuilder();
			while(t-->0) {
				int n=s.nextInt();
				int[] arr=new int[n];
				for(int i=0;i<n;i++) {
					arr[i]=s.nextInt();
				}
				PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
				for(int i:arr)
					pq.add(i);
				boolean won=false;
				while(pq.size()>0) {
					int a=pq.poll()-1;
					if(pq.isEmpty()) {
						sb.append("T\n");
						won =true;
						break;
					}
					int b=pq.poll()-1;
					if(a>0)
						pq.add(a);
					if(b>0)
						pq.add(b);
				}
				if(won==false) {
					sb.append("HL\n");
				}
				
			}
			System.out.println(sb.toString());
			
		}catch(Exception e) {
			System.out.println(e);
			return;
		}

	}
	
}

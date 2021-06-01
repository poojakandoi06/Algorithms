package Div2_666;

import java.util.HashMap;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		try {
			Scanner s=new Scanner(System.in);
			int t=s.nextInt();
			while(t-->0) {
				int n=s.nextInt();
				HashMap<Character,Integer> map=new HashMap<>();
				for(int i=0;i<n;i++) {
					String str=s.next();
					for(char c:str.toCharArray()) {
						map.put(c, map.getOrDefault(c, 0)+1);
					}
				}
				boolean res=true;
				for(char c:map.keySet()) {
					if(map.get(c)%n!=0) {
						res=false;
						break;
					}
				}
				if(res==true)
					System.out.println("YES");
				else
					System.out.println("NO");
				
			}
			
			
		}catch(Exception e) {
			return;
		}

	}

}

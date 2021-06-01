package Encoding;

import java.util.HashMap;
import java.util.Scanner;

public class ECAUG208 {
	public static class trienode {
		trienode[] child;
		boolean found;
		String str;

		public trienode() {
				this.child=new trienode[26];
				
		}
		
	}
	public static void add(String str,trienode root) {
		trienode node=root;
		for(int i=str.length()-1;i>=0;i--) {
			char c=str.charAt(i);
			if(node.child[c-'a']==null) {
				node.child[c-'a']=new trienode();
			}
			 node=node.child[c-'a'];
		}
		node.found=true;
		node.str=str;
	}
	public static String find(StringBuilder sb, trienode root,HashMap<String, Integer> map) {
		trienode node=root;
		StringBuilder res=new StringBuilder();
		for(int i=sb.length()-1;i>=0;i--) {
			char c=sb.charAt(i);
			if(node.child[c-'a']==null)
				return res.toString();
			node=node.child[c-'a'];
			if(node.found==true) {
				String str=node.str;
				int val=map.get(str);
				if(val%2==0)
					res.append(1);
				else
					res.append(0);
			}
		}
		return res.toString();
	}

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			HashMap<String, Integer> map = new HashMap<>();
			trienode root = new trienode();
			for (int i = 0; i < n; i++) {
				String str = s.next();
				map.put(str, i + 1);
				add(str,root);
			}
			int k = s.nextInt();
			StringBuilder sb = new StringBuilder();
			StringBuilder res = new StringBuilder();
			for (int i = 0; i < k; i++) {
				String ss = s.next();
				sb.append(ss);
				String str = find(sb,root,map);
				if(!str.equals("")) {
					res.append(str);
				}
			}
			System.out.println(res.toString());

		} catch (Exception e) {
			System.out.println(e);
			return;
		}

	}
	

}

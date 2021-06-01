package dp;

import java.util.HashSet;

public class word_break {

	public static void main(String[] args) {
		String str="leetcode";
		HashSet<String> set=new HashSet<String>();
		set.add("leet");
		set.add("code");
		System.out.println(word_break(str,set));

	}
	public static boolean word_break(String str, HashSet<String> dictionary) {
		boolean[] dp=new boolean[str.length()+1];
		dp[0]=true;
		for(int i=1;i<dp.length;i++) {
			char ch=str.charAt(i-1);
			if(i==1 && dictionary.contains(ch+"")) {
				dp[i]=true;
				continue;
			}
			for(int j=i-1;j>=0;j--) {
				if(dp[j]==true) {
					String stringtobechecked =str.substring(j,i);
					if(dictionary.contains(stringtobechecked))
						dp[i]=true;
				}
			}
		}
		return dp[dp.length-1];
		
	}

}

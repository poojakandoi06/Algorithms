package leetcode;

import java.awt.List;
import java.util.ArrayList;

public class test_ib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba";
			String B = "babaaa";
			System.out.println(strStr(A,B));
	}
	public static int strStr(final String A, final String B) {
        int i=0;
        int j=0;
        int start=0;
        while(i<B.length() && j<A.length()){
            if(A.charAt(j)==B.charAt(i)){
                if(i==0){
                    start=j;
                }
                System.out.print(B.charAt(i));

                i++;
                j++;
            }
            else{
                j=j-i+1;
                i=0;
                System.out.print(" ");
                
            }
            if(i==B.length()){
                return start;
            }
        }
        return -1;
    }
}

package Educational_round_95;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		 Scanner s=new Scanner(System.in);
	        int n=s.nextInt();
	        int[][] x=new int[n*3][2];
	        int[][] y=new int[n*3][2];
	        for(int i=0;i<n;i++){
	            x[i*3][0]=s.nextInt();
	            x[i*3][1]=i;
	            y[i*3][0]=(s.nextInt());
	            y[i*3][1]=i;
	            x[i*3+1][0]=(s.nextInt());
	            x[i*3+1][1]=i;
	            y[i*3+1][0]=(s.nextInt());
	            y[i*3+1][1]=i;
	            x[i*3+2][0]=(s.nextInt());
	            x[i*3+2][1]=i;
	            y[i*3+2][0]=(s.nextInt());
	            y[i*3+2][1]=i;
	        }
	        Arrays.sort(x,(a,b)->(a[0]-b[0]));
	        Arrays.sort(y,(a,b)->a[0]-b[0]);
//	        for(int i=0;i<x.length;i++) {
//	        	System.out.print(x[i][0]+" ");
//	        }
//	        System.out.println();
	        for(int i=0;i<x.length;i++) {
	        	System.out.print(y[i][0]+"-"+y[i][1]+" ");
	        }
	        System.out.println();
	        int q=s.nextInt();
	        //System.out.println(q);
	        for(int i=0;i<q;i++){
	            char point=s.next().charAt(0);
	            s.next();
	            int mm=Integer.valueOf(s.next());
	            if(point=='x'){
	                int count=check(x,mm);
	                System.out.println(count);
	            }
	            else{
	                 int count=check(y,mm);
	                 
	                System.out.println(count);
	            }
	        }

	}
	public static int check(int[][] x, int val) {
		int l=0;
		int r=x.length-1;
		int num=-1;
		while(l<=r) {
			int mid=(l+r)/2;
			if(x[mid][0]==val) {
				while(x[mid][0]==val)
					mid++;
				num=mid;
				break;
			}
			else if(x[mid][0]>val) {
				num=mid;
				r=mid-1;
			}
			else {
				l=mid+1;
			}
		}
		HashSet<Integer> set=new HashSet<>();
		for(int i=0;i<num;i++) {
			if(x[i][0]!=val)
			set.add(x[i][1]);
		}
		System.out.println(set.toString());
		int count=0;
		for(int i=num;i<x.length;i++) {
			if(set.contains(x[i][1]) && x[i][0]!=val) {
				count++;
				set.remove(x[i][1]);
			}
		}
		return count;
	}

}

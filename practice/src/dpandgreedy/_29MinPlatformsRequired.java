package dpandgreedy;
import java.util.*;

public class _29MinPlatformsRequired {

	public static void main(String[] args) {
		int[] arrival = {900,940,950,1100,1500,1800};
		int[] depart = {910,1120,1200,1130,1900,2000};
		solution(arrival, depart);
	}
	
	public static void solution(int[] arrival, int[] depart){
		Arrays.sort(arrival);
		Arrays.sort(depart);
		int platforms = 0;
		int max = Integer.MIN_VALUE;
		int i = 0, j = 0;
		while(i < arrival.length && j < depart.length){
			if(arrival[i] < depart[j]){
				platforms++;
				max = Math.max(max, platforms);
				i++;
			}else{
				j++;
				platforms--;
			}
		}
		System.out.println(max);
	}
}

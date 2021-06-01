package dpandgreedy;

import java.util.*;

public class _39BoxStackingProblem {

	public static class box implements Comparable<box> {
		int length;
		int width;
		int height;
		int area;

		public box(int length, int width, int height) {
			this.length = length;
			this.width = width;
			this.height = height;
		}

		@Override
		public int compareTo(box o) {
			return o.area - this.area;
		}

	}

	public static void main(String[] args) {
		box[] arr = new box[4];
		arr[0] = new box(6, 7, 4);
		arr[1] = new box(2,3,1);
		arr[2] = new box(5,6,4);
		arr[3] = new box(12,32,10);
		solution(arr,4);
	}

	public static void solution(box[] arr, int n) {
		box[] nbox = new box[3 * n];
		for (int i = 0; i < n; i++) {
			box b = arr[i];
			nbox[3 * i] = new box(Math.max(b.length, b.width), Math.min(b.length, b.width), b.height);
			nbox[(3 * i) + 1] = new box(Math.max(b.height, b.width), Math.min(b.height, b.width), b.length);
			nbox[(3 * i) + 2] = new box(Math.max(b.length, b.height), Math.min(b.length, b.height), b.width);
		}
		for (int i = 0; i < nbox.length; i++) {
			nbox[i].area = nbox[i].length * nbox[i].width;
		}

		Arrays.sort(nbox);

		int[] ans = new int[3 * n];
		for(int i = 0 ; i < 3 * n; i++) {
			box b = nbox[i];
			int val = 0;
			for(int j = 0 ; j < i; j++) {
				box prevbox = nbox[j];
				if(b.length < prevbox.length && b.width < prevbox.width) {
					val = Math.max(val, ans[j]);
				}
			}
			ans[i] = val + b.height;
		}
		
		int max = -1;
		for(int i = 0 ; i < nbox.length ;i++) {
			max = Math.max(max, ans[i]);
		}
		System.out.println(max);
	}

}

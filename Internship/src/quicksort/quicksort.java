package quicksort;

import java.util.Stack;

public class quicksort {

	public static void main(String[] args) {
		int[] F = new int[] { 12, 2, 16, 30, 8, 28, 4, 10, 20, 6, 18 };
		System.out.println("Given Array:");
		for (int i = 0; i < F.length; i++) {
			System.out.print(F[i] + " ");
		}
		System.out.println();
		nonrecursive_quicksort(F, 0, F.length - 1);
		System.out.println("Output of non recursive quicksort function");
		for (int i = 0; i < F.length; i++) {
			System.out.print(F[i] + " ");
		}
		 System.out.println();
		 System.out.println("Output of recursive quicksort function");
		 F=new int[] {12,2,16,30,8,28,4,10,20,6,18};
		 Recursive_quicksort(F, 0, F.length-1);
		 for(int i=0;i<F.length;i++) {
		 System.out.print(F[i]+" ");
		 }

	}

	public static void Recursive_quicksort(int[] arr, int left, int right) {
		if (left < right) {
			int partition = partition(arr, left, right);
			Recursive_quicksort(arr, left, partition - 1);
			Recursive_quicksort(arr, partition + 1, right);

		}
	}

	public static void nonrecursive_quicksort(int[] arr, int left, int right) {

		Stack<Integer> st = new Stack<Integer>();
		st.push(left);
		st.push(right);
		while (st.size() > 0) {
			int r = st.pop();
			int l = st.pop();
			int partition = partition(arr, l, r);
			if (partition - 1 > l) {
				st.push(l);
				st.push(partition - 1);

			}
			if (partition + 1 < r) {
				st.push(partition + 1);
				st.push(r);
			}
		}
	}

	public static int partition(int[] arr, int left, int right) {
		int median = MedianOfThree(arr, left, right);
		swap(arr, median, right);
		int pivot = arr[right];
		int start = left - 1;
		for (int i = left; i < right; i++) {
			if (arr[i] < pivot) {
				start++;
				swap(arr, start, i);
			}
		}
		swap(arr, start + 1, right);

		return start + 1;
	}

	public static int MedianOfThree(int[] arr, int left, int right) {
		int mid = (left + right) / 2;
		if ((arr[left] > arr[mid]) != (arr[left] > arr[right]))
			return left;
		else if ((arr[mid] > arr[left]) != (arr[mid] > arr[right]))
			return mid;
		else
			return right;
	}

	public static void swap(int[] arr, int l, int r) {
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}

}

package sorting;

public class counting_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 6, 1, 6, 7, 3, 1 };
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

	}
	// max element of array==total
	public static int total=10;
	public static void sort(int[] arr) {
		
		int[] count=new int[total];
		for(int i=0;i<arr.length;i++) {
			count[arr[i]]++;
		}
		int c=0;
		for(int i=0;i<count.length;i++) {
			while(count[i]>0) {
				arr[c++]=i;
				count[i]--;
			}
		}
	}
	public static void sort1(int[] arr) {
		int[] count=new int[total];
			int[] output=new int[arr.length];
			for(int i=0;i<arr.length;i++) {
				count[arr[i]]++;
			}
			for(int i=1;i<count.length;i++)
				count[i]+=count[i-1];
			for(int i=0;i<arr.length;i++) {
				output[count[arr[i]]-1]=arr[i];
				count[arr[i]]--;
			}
			for(int i=0;i<arr.length;i++)
				arr[i]=output[i];
	}

}

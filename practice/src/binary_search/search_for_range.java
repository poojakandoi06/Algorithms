package binary_search;

public class search_for_range {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int[] searchRange(int[] arr, int target) {
		int first=firstOccurance(arr,target);
		if(first==-1)
			return new int[] {-1,-1};
		int last=lastoccurance(arr,target);
		return new int[] {first,last};
		
	}
	private static int lastoccurance(int[] arr, int target) {
		int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (arr[mid] == target && (mid == arr.length - 1 || arr[mid + 1] > target)) {
                return mid;
            } else if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
	}
	private static int firstOccurance(int[] arr, int target) {
		int low=0;
		int high=arr.length-1;
		while(low<=high) {
			int mid=low+(high-low)/2;
			if(arr[mid]==target && (mid==0 || arr[mid-1]<target)) {
				return mid;
			}
			else if(arr[mid]>=target)
				high=mid-1;
			else
				low=mid+1;
		}
		return -1;
	}

}

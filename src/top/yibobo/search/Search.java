package top.yibobo.search;

//查找
public class Search {
	
	
	//二分查找普通实现
	public static int BinarySearch(int[] array,int key) {
		
		int left = 0,right = array.length-1;
		
		while(left<=right) {
			
			int mid = (right-left)/2+left;//直接相加/2有可能范围溢出
			
			if(key == array[mid]) {
				return mid;
			}
			
			if(key>array[mid]) {
				left = mid+1;
			}
			
			if(key<array[mid]) {
				right = mid-1;
			}
			
		}
		
		return -1;
	}
	
	//二分查找递归实现
	public static int BinarySearch(int[] array,int key,int left,int right) {
		
		int mid = (right-left)/2+left;
		
		if(array[mid] == key) {
			return mid;
		}else if(left>right) {
			return -1;
		}else {
			
			if(array[mid] > key)return BinarySearch(array, key, left, mid-1);
			if(array[mid] < key)return BinarySearch(array, key, mid+1, right);
			
		}
		
		return -1;
		
		
	}
	
	
}

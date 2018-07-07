package top.yibobo.sort;

import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
		int[] arr = {8,9,7,4,5,6,1,2,3};
 		
		insertionSort(arr);
		
		System.err.println(Arrays.toString(arr));
	}
	
	public static void insertionSort(int[] arr) {
		
		int j,temp;
		
		for(int i = 0;i < arr.length ; i++) {
			temp = arr[i];
			j = i;
			
			while(j>0 && temp<arr[j-1]) {
				arr[j] = arr[j-1];
				j--;
			}
			
			
			arr[j] = temp;//插入
			
			
		}
	}
	
	
}

package top.yibobo.sort;

import java.util.Arrays;
import java.util.Random;

public class Timing {

	public static void main(String[] args) {
		
		EasySortTiming();
	}
	
	
	private static void EasySortTiming() {
		
		int num = 200000;
		int[] array1 = getArray(num);
		int[] array2 = Arrays.copyOf(array1, num);
		int[] array3 = Arrays.copyOf(array1, num);;
		
		
		
		long time1 = System.currentTimeMillis();
		EasySort.StraightInsertionSort(array3);
		long time2 = System.currentTimeMillis();
		EasySort.BubbleSort(array2);
		long time3 = System.currentTimeMillis();
		EasySort.SelectionSort(array1);
		long time4 = System.currentTimeMillis();
		
		System.out.println(num+"数字级的直接插入排序毫秒值:"+(time2-time1));
		System.out.println(num+"数字级的冒泡排序毫秒值:"+(time3-time2));
		System.out.println(num+"数字级的选择排序毫秒值:"+(time4-time3));
	}
	
	
	private static int[] getArray(int num) {
		int[] array = new int[num];
		
		Random ra = new Random();
		
		
		for(int i = 0;i<array.length;i++) {
			array[i] = ra.nextInt(100000);
		}
		
		return array;
	}

}

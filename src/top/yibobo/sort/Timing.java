package top.yibobo.sort;

import java.util.Arrays;
import java.util.Random;

public class Timing {

	public static void main(String[] args) {
		
		//EasySortTiming();
		SeniorSort();
	}


	private static void SeniorSort() {
		int num = 20000000;
		int[] array = getArray(num);
		int[] array2 = Arrays.copyOf(array, num);
		int[] array3 = Arrays.copyOf(array, num);
		int[] array4 = Arrays.copyOf(array, num);
		System.out.println("数组创建完毕");
		long time1 = System.currentTimeMillis();
		SeniorSort.ShellKnuthsSort(array);
		long time2 = System.currentTimeMillis();
		Arrays.sort(array);
		long time3 = System.currentTimeMillis();
		SeniorSort.QuickSort(array3, 0, array.length-1);
		long time4 = System.currentTimeMillis();
		new HeapSort().heapSort(array4);
		long time5 = System.currentTimeMillis();
		System.out.println(num+"数字级的希尔排序毫秒值:"+(time2-time1));
		System.out.println(num+"数字级java自带Arrays.sort排序:"+(time3-time2));
		System.out.println(num+"数字级快速排序:"+(time4-time3));
		System.out.println(num+"数字级堆排序:"+(time5-time4));
		
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

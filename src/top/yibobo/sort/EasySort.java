package top.yibobo.sort;

import java.util.Arrays;


//简单排序的时间复杂度都是O(N2)级别，效率比较差
//以效率来排名的话应该是 直接插入排序>选择排序>冒泡排序
public class EasySort {

	public static void main(String[] args) {
		
		/*int[] arrays = {5,6,7,8,9,10};
		reversal(arrays);
		System.out.println(Arrays.toString(arrays));*/
		
		int[] arrays = {16,15,1,4,78,142,14,5,41,54,24,54,22,358,46};
		StraightInsertionSort(arrays);
		System.out.println(Arrays.toString(arrays));
		
	}
	
	
	//数组逆序
	//这个不是排序啊，写着好玩
	public static void reversal(int[] array) {
		for(int i = 0,j=array.length-1;i<array.length/2;i++,j--) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		
	}
	
	//选择排序和冒泡排序执行了相同次数的比较：N*（N-1）/2，但是至多只进行了N次交换。
	//选择排序是每一次从待排序的数据元素中选出最小的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。
	public static void SelectionSort(int[] array) {
		for(int i =0;i<array.length-1;i++) {
			
			int min=i;//记录最小值
			
			for(int j =i+1;j<array.length;j++) {
				if(array[j]<array[min]) {//只要遍历出的j下标元素比min下标元素要小，就保存起来
					min = j;
				}
			}
			
			if(i!=min) {//只要最小值不等于自己，就交换位置，把最小值放在最前面
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
			
		}
	}
	
	
	//冒泡排序，计算次数为:（N-1）+（N-2）+...+1 = N*（N-1）/2
	//冒泡每次都要交换，在简单排序中，效率最差
	public static void BubbleSort(int[] array) {
		
		//这个外层的for循环代表内层循环要循环多少次，即多少次循环能够完成一轮排序
		//每经过一轮排序，内层循环范围缩小
		for(int i = 0;i<array.length-1;i++) {
			
			
			//该循环执行完毕后，数组中最大值处于最大索引，即“冒泡”
			for(int j = 1;j<array.length-i;j++) {
				
				if(array[j-1]>array[j]) {
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
			
		}
	}
	
	//直接插入排序基本思想是每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去，直到插完所有元素为止。
	public static void StraightInsertionSort(int[] array) {
		int j;
		
		for(int i = 1; i < array.length; i++) {//第一次循环的时候把下标为0的那单个数据当成有序序列
			int temp = array[i];//这是要插的数据
			j=i;
			
			while(j>0 && temp < array[j-1]) {//从有序的序列最右边开始比较，只要要插入的数据比array[j-1]要小
				
				array[j] = array[j-1];//就把array[j-1]往后面挪动
				j--;
			}
			
			//此时该往后挪的都已经挪了
			//如果没进while循环，代表已经有序的序列加上这回遍历的数据也是个有序序列，重新赋下值而已
			array[j] = temp;//插入
		}
	}
	
	
	
	
	
	
	
}

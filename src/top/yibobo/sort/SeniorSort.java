package top.yibobo.sort;

//高级排序
public class SeniorSort {

	// 直接插入排序基本思想是每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去，直到插完所有元素为止。
	public static void StraightInsertionSort(int[] array) {
		int j;

		for (int i = 1; i < array.length; i++) {// 第一次循环的时候把下标为0的那单个数据当成有序序列
			int temp = array[i];// 这是要插的数据
			j = i;

			while (j > 0 && temp < array[j - 1]) {// 从有序的序列最右边开始比较，只要要插入的数据比array[j-1]要小

				array[j] = array[j - 1];// 就把array[j-1]往后面挪动
				j--;
			}

			// 此时该往后挪的都已经挪了
			// 如果没进while循环，代表已经有序的序列加上这回遍历的数据也是个有序序列，重新赋下值而已
			array[j] = temp;// 插入
		}
	}
	
	//希尔排序通过加大插入排序中元素的间隔，并在这些有间隔的元素中进行插入排序，从而使数据项能够大跨度的移动。
	//当这些数据项排过一趟序后，希尔排序算法减小数据项的间隔再进行排序，依次进行下去，最后间隔为1时，就是简单的直接插入排序。
	//希尔排序 knuth 间隔序列 3h+1
	public static void ShellKnuthsSort(int[] array) {
		int step = 1;//步长
		int len = array.length;
		
		while(step<len/3) {//取得间隔
			step = step*3+1;
		}
		
		
		while(step > 0) {
			
			
			
			step = (step-1)/3;//减小数据项的间隔，继续排序
		}
		
	}
}

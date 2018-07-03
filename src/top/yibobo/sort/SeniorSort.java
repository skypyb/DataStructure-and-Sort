package top.yibobo.sort;

import java.util.Arrays;

//高级排序
public class SeniorSort {

	public static void main(String[] args) {
		
		
		int[] arrays = {78,15,6,4,16,11,3,5,41,54,24,54,22,38,46};
		QuickSort(arrays,0,arrays.length-1);
		System.out.println(Arrays.toString(arrays));
		
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
			
			one:for(int i = step ; i<len ; i++) {
				
				int temp = array[i];//i作为初始右指针，把该位置数值保存起来，作为要插入的值
				
				//j在每次在one循环第一次时，和间隔是一样的，然后随着i的自增，j也会自增。但是间隔不会自增
				//step这个用于保存间隔的数字只有在one循环结束后才会变小
				int j = i;
				
				//将左右指针进行对比，当右指针数据temp小于(j-step)所代表的左指针数据时，才会进入while循环
				//在while循环中，j为右指针，j-step(右指针减去步长)为左指针
				while(j>step-1 && temp < array[j-step]) {
					array[j] = array[j-step];//将左指针指向的数据，赋值给右指针索引，此时右指针所代表的原数据消失，但是不用担心，temp已经保存下来了
					j-=step;//交换完，左指针会再次向左边移动，试图寻找比temp更大的数据，如果找到则继续将该数据向右移动，直到该区间相对有序
				}
				
				if(array[j] != temp)//如果没进while循环，代表已经有序的序列加上这回遍历的数据也是个有序序列
				array[j] = temp;//把保存起来的temp插入进去
				
			}
			
			step = (step-1)/3;//减小数据项的间隔，继续排序
		}
	}
	
	
	//快排
	public static void QuickSort(int[] array,int left,int right) {
		if(left>=right)return;
		
		int i = left,j= right,t;
		 
		int temp = array[left];//保存基准值
		
		
		
		while(i != j) {
			
			while(i<j && array[j]>=temp) //右指针向左移动,直到右指针比基准值要小
				j--;
			
			while(i<j && array[i]<=temp) //左指针向右移动，直到左指针比基准值要大
				i++;
			
			if(i<j) {
				t = array[i];
				array[i]=array[j];
				array[j] = t;
			}
			
		}
		
		//基准值归位
		array[left] = array[i];
		array[i] = temp;
		
		
		QuickSort(array,left,i);
		QuickSort(array,i+1,right);
		
	}
	
}

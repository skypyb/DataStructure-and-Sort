package top.yibobo.sort;

import java.util.Arrays;

/**
 * 堆排序
 * @author pyb
 *
 */
public class HeapSort {
	
	private int[] arr;
	//int类型数组:{6,5,7,9,8,4,1,2,3}
	/*			
	 *	完全二叉树形式
	 * 			6
	 * 		  /	  \
	 * 		5		7
	 * 	   / \	   / \
	 *	  9	  8	  4   1
	 *	 / \
	 * 	2	3
	 * 
	 */
	public static void main(String[] args) {
		
		
		int[] arrays = {78,15,6,4,16,11,3,5,41,54,24,54,22,38,46};
		new HeapSort().heapSort(arrays);
		
		System.out.println(Arrays.toString(arrays));
		
	}
	
	public void heapSort(int[] arr) {
		this.arr=arr;
		int len =arr.length-1;
		
		int node = (len-1)>>1;//-1除2得到第一个非叶子节点，只有该节点和该节点之前的节点有儿子
		
		//将数据堆化、i作为完全二叉树中位置最后的父节点，一直从最后遍历到最开始，从而构建一个最大堆
		for(int i=node;i>=0;i--) {
			maxHeapify(i,len);
		}
		
		//每次都是将第一位的数据和最后一位的进行交换，同时遍历长度-1
		//然后在将放到第一位的末尾元素进行堆化处理，使其符合堆得特性
		//直到最后未排序的堆长度变为0
		while(len>=0) {
			swap(0,len--);
			maxHeapify(0, len);
		}
		
	}
	
	
	/**
	 * 调整索引为i处的数据，使其符合堆的特性
	 * 将一个子树的最大元素置于该子树的父节点(即与父节点交换)
	 * @param i 需要变成堆的数据索引
	 * @param len 未排序的数组（堆）长度
	 */
	private void maxHeapify(int i,int len) {
		int lnode = (i<<1)+1;//得到i这个父节点的左孩子
		int rnode = lnode+1;//这个是右孩子
		
		int maxNode = lnode;//默认最大儿子是左边，因为有可能出现没有右儿子的情况
		
		//只有在右孩子存在(如果>len就是不存在了)并且比左孩子要大时，maxNode指向右孩子
		if(rnode<=len && arr[rnode]>arr[lnode]) maxNode=rnode;
		
		if(lnode>len)return;//左子节点的索引超出计算范围，直接返回
		
		if(arr[i]<arr[maxNode]) {//如果父节点比子节点要小，则交换位置
			swap(i,maxNode);
			maxHeapify(maxNode,len);//此时位置已经交换完毕，递归调用自身，直到该父节点(i)下所有子树满足堆的特性
		}
		
	}
	
	private void swap(int i,int j) {//交换数组元素的方法
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
}

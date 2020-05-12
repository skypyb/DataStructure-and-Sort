package com.skypyb.sort.impl;

import com.skypyb.sort.AbstractSortAlgorithm;
import com.skypyb.sort.SortAlgorithm;


public class Merge extends AbstractSortAlgorithm implements SortAlgorithm {

    private ThreadLocal<Comparable[]> tempArray = new ThreadLocal<>();

    private boolean enableInsertion = false;

    public Merge() {
        this(false);
    }

    public Merge(boolean enableInsertion) {
        this.enableInsertion = enableInsertion;
    }

    @Override
    public void sort(Comparable[] arr) {
        tempArray.set(new Comparable[arr.length]);//分配足够的空间
        sort(arr, 0, arr.length - 1);
    }


    private void sort(Comparable[] arr, int lo, int hi) {

        //开启插入排序 小于十五个直接插入 不递归进行归并了
        if (enableInsertion && hi - lo <= 15) {

            for (int i = lo; i <= hi; i++) {
                for (int j = i; j > lo && less(arr[j], arr[j - 1]); j--) {
                    swap(arr, j, j - 1);
                }
            }
            return;
        } else if (lo >= hi) return;

        //中间数
        int mid = lo + (hi - lo) / 2;

        //分治, 递归排序数组左右两边
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);

        //排序完了 开始归并 lo...mid / mid+1...hi 两个有序数组

        Comparable[] temp = tempArray.get();

        //复制元素到临时数组
        for (int arrIndex = lo; arrIndex <= hi; arrIndex++) {
            temp[arrIndex] = arr[arrIndex];
        }

        int i = lo, j = mid + 1;

        //遍历临时数组, 将排序正确的值塞进原来的数组里
        for (int k = lo; k <= hi; k++) {

            if (i > mid) arr[k] = temp[j++];    //左边的指针跑完了, 复制右边的所有剩余数据
            else if (j > hi) arr[k] = temp[i++];    //右边的指针跑完了，复制左边的所有剩余数据
            else if (less(temp[i], temp[j])) arr[k] = temp[i++];    //两边都还有剩, 比较一波 设置值
            else arr[k] = temp[j++];
        }
    }

}

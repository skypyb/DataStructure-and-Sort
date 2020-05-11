package com.skypyb.sort.impl;

import com.skypyb.sort.AbstractSortAlgorithm;
import com.skypyb.sort.SortAlgorithm;

/**
 * 插入排序
 * 每次交换都会将前面的数组视为有序
 * 将遍历到的元素插入到有序数组的正确位置
 */
public class Insertion extends AbstractSortAlgorithm implements SortAlgorithm {

    @Override
    public void sort(Comparable[] arr) {

        for (int i = 1; i < arr.length; i++) {

            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                //找出数组前面比当前遍历的还要小的交换
                swap(arr, j, j - 1);
            }

        }
    }
}

package com.skypyb.sort.impl;


import com.skypyb.sort.AbstractSortAlgorithm;
import com.skypyb.sort.SortAlgorithm;

/**
 * 选择排序
 * 每次循环找到数组中最小的元素, 将其和头部元素交换
 * 最终得到有序的数组
 * <p>
 * 因为他在不断地选择剩余数组中的最小者
 */
public class Selection extends AbstractSortAlgorithm implements SortAlgorithm {

    @Override
    public void sort(Comparable[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int min = i;

            //每次遍历招出最小的元素
            for (int j = i + 1; j < arr.length; j++) {
                if (less(arr[j], arr[min])) min = j;
            }

            //将最小的元素和当前遍历元素交换
            swap(arr, i, min);
        }

    }


}

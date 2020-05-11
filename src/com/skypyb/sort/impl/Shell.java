package com.skypyb.sort.impl;

import com.skypyb.sort.AbstractSortAlgorithm;
import com.skypyb.sort.SortAlgorithm;

public class Shell extends AbstractSortAlgorithm implements SortAlgorithm {

    @Override
    public void sort(Comparable[] arr) {


        int h = 1;

        //计算希尔排序的区间
        while (h < arr.length) {
            h = h * 3 + 1;
        }


        while (h > 0) {

            //最后一定会有一次h=1, 对数据进行普通的插入排序
            for (int i = h; i < arr.length; i++) {
                //将 arr[i] 插入到 arr[i-h]、arr[i-2*h]... 之间去
                for (int j = i; j >= h && less(arr[j], arr[j - h]); j -= h) {
                    swap(arr, j, j - h);
                }
            }

            h /= 3;
        }
    }
}

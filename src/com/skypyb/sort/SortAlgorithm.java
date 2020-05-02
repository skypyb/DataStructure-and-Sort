package com.skypyb.sort;

public interface SortAlgorithm {

    void setContext(SortContext context);

    void sort(Comparable[] arr);

    //判断左边是否小于右边
    default boolean less(Comparable l, Comparable r) {
        return l.compareTo(r) < 0;
    }

    //交换数组中两个元素的位置
    default void swap(Comparable[] comparables, int i, int j) {
        var temp = comparables[i];
        comparables[i] = comparables[j];
        comparables[j] = temp;
    }
}
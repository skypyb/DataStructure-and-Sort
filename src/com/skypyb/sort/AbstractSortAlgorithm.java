package com.skypyb.sort;

public abstract class AbstractSortAlgorithm implements SortAlgorithm {

    private SortContext context;

    @Override
    public void setContext(SortContext context) {
        this.context = context;
    }

    @Override
    public boolean less(Comparable l, Comparable r) {
        context.incrLess();
        return SortAlgorithm.super.less(l, r);
    }

    @Override
    public void swap(Comparable[] comparables, int i, int j) {
        context.incrSwap();
        SortAlgorithm.super.swap(comparables, i, j);
    }

}

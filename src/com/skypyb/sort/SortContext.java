package com.skypyb.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public final class SortContext {

    private SortAlgorithm algorithm;

    private int lessNum;

    private int swapNum;

    private boolean print;

    private Comparable[] arr;

    public SortContext(SortAlgorithm algorithm) {
        algorithm.setContext(this);
        this.algorithm = algorithm;
    }

    protected void incrLess() {
        this.lessNum++;
    }

    protected void incrSwap() {
        this.swapNum++;
    }

    public SortContext printArray(boolean print) {
        this.print = print;
        return this;
    }

    public SortContext randomIntegerArray(int size) {
        return randomIntegerArray(size, 10000);
    }

    public SortContext randomIntegerArray(int size, int maxNum) {
        Random random = new Random();
        this.arr = IntStream.rangeClosed(0, size).map(i -> random.nextInt(maxNum)).boxed().toArray(Integer[]::new);
        return this;
    }

    public SortContext algorithm(SortAlgorithm algorithm) {
        algorithm.setContext(this);
        this.algorithm = algorithm;
        return this;
    }

    public void sort() {

        Comparable[] arr = Arrays.copyOf(this.arr, this.arr.length);

        System.out.printf("Sort start, algorithm: %s, array type: %s, array length:%s.",
                this.algorithm.getClass().getSimpleName(), this.arr.getClass().getComponentType().getTypeName(), arr.length);

        System.out.println();
        System.out.println();

        if (print) System.out.println(Arrays.toString(arr));

        Long m = System.currentTimeMillis();
        algorithm.sort(arr);

        if (print) System.out.println(Arrays.toString(arr));

        long time = System.currentTimeMillis() - m;
        System.out.println();
        System.out.printf("Sort end, spend time: %sms, swap num: %s, less num: %s. ", time, swapNum, lessNum);
        System.out.println();

        this.swapNum = 0;
        this.lessNum = 0;
    }


}

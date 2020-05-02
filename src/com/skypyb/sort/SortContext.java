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


    public void sort() {
        System.out.printf("Sort start, algorithm: %s, array type: %s.",
                this.algorithm.getClass().getSimpleName(), arr.getClass().getComponentType().getTypeName());

        System.out.println();
        System.out.println();

        if (print) System.out.println(Arrays.toString(arr));

        algorithm.sort(arr);

        if (print) System.out.println(Arrays.toString(arr));


        System.out.println();
        System.out.printf("Sort end, swap num: %s, less num: %s. ", swapNum, lessNum);
        System.out.println();

        this.swapNum = 0;
        this.lessNum = 0;
    }


}

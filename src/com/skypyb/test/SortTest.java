package com.skypyb.test;

import com.skypyb.sort.SortContext;
import com.skypyb.sort.impl.Insertion;
import com.skypyb.sort.impl.Merge;
import com.skypyb.sort.impl.Selection;
import com.skypyb.sort.impl.Shell;

public class SortTest {


    public static void main(String[] args) {

        SortContext sortContext = new SortContext(new Shell());
        sortContext.printArray(false).randomIntegerArray(500 * 10000).sort();

        System.out.println("----------------------------------");

        sortContext.algorithm(new Merge()).sort();

        System.out.println("----------------------------------");

        sortContext.algorithm(new Merge(true)).sort();

        System.out.println("----------------------------------");

    }
}

package com.skypyb.test;

import com.skypyb.sort.SortContext;
import com.skypyb.sort.impl.Insertion;
import com.skypyb.sort.impl.Selection;
import com.skypyb.sort.impl.Shell;

public class SortTest {


    public static void main(String[] args) {

        SortContext sortContext = new SortContext(new Selection());
        sortContext.printArray(true).randomIntegerArray(50000).sort();

        System.out.println("----------------------------------");

        sortContext.algorithm(new Insertion()).sort();

        System.out.println("----------------------------------");

        sortContext.algorithm(new Shell()).sort();

        System.out.println("----------------------------------");

    }
}

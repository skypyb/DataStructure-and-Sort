package com.skypyb.test;

import com.skypyb.sort.SortContext;
import com.skypyb.sort.impl.Selection;

public class SortTest {


    public static void main(String[] args) {

        SortContext sortContext = new SortContext(new Selection());
        sortContext.printArray(false).randomIntegerArray(50000).sort();

    }
}

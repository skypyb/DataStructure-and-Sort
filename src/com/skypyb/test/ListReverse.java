package com.skypyb.test;

import com.skypyb.structure.SNode;

public class ListReverse {


    public static void main(String[] args) {

        SNode<Integer> a = new SNode(1), b = new SNode(2), c = new SNode(3), d = new SNode(4), e = new SNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(a);
        a = reverse1(a);
        System.out.println(a);
        a = reverse2(a);
        System.out.println(a);
    }

    //反转链表
    public static SNode reverse1(SNode x) {

        SNode first = x; //开头节点
        SNode current = null; //当前链表

        while (first != null) {
            SNode temp = first.next; //先保存下一个节点

            first.next = current;
            current = first;

            first = temp;
        }

        return current;
    }

    //反转链表(递归)
    public static <E> SNode<E> reverse2(SNode<E> x) {

        if (x == null || x.next == null) return x;

        SNode r = reverse2(x.next);
        x.next.next = x;
        x.next = null;

        return r;
    }
}

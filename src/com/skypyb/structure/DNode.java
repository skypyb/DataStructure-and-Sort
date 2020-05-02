package com.skypyb.structure;

//双向链表的节点
public class DNode<E> {

    public E item;
    public DNode<E> pre;
    public DNode<E> next;

    DNode(E item) {
        this.item = item;
    }
}

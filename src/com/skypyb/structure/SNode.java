package com.skypyb.structure;

//单向链表的节点
public class SNode<E> {

    public E item;
    public SNode<E> next;

    public SNode(E item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", item, next);
    }
}

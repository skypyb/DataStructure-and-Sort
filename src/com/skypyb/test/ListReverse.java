package com.skypyb.test;

public class ListReverse {

    static class Node<E> {
        private E item;
        private Node<E> next;

        Node(E item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return String.format("%s : %s", item, next);
        }
    }


    public static void main(String[] args) {

        Node<Integer> a = new Node(1), b = new Node(2), c = new Node(3), d = new Node(4), e = new Node(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(a);
//        System.out.println(reverse1(a));
        System.out.println(reverse2(a));
    }

    //反转链表
    public static Node reverse1(Node x) {

        Node first = x; //开头节点
        Node current = null; //当前链表

        while (first != null) {
            Node temp = first.next; //先保存下一个节点

            first.next = current;
            current = first;

            first = temp;
        }

        return current;
    }

    //反转链表(递归)
    public static <E> Node<E> reverse2(Node<E> x) {

        if (x == null || x.next == null) return x;

        Node r = reverse2(x.next);
        x.next.next = x;
        x.next = null;

        return r;
    }
}

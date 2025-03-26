package org.example;

class BSTNode<E> {
    E data;
    BSTNode<E> left;
    BSTNode<E> right;

    public BSTNode(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
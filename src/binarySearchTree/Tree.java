package binarySearchTree;

public interface Tree<E> {
    boolean insert(E e);

    void inorder();

    int getSize();

    void postOrder();

    void preorder();

    boolean delete(E e);

    boolean isExits(E e);
}
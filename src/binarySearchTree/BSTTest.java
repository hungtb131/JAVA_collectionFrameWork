package binarySearchTree;

public class BSTTest {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(8);
        tree.insert(4);
        tree.insert(12);
        tree.insert(2);
        tree.insert(6);
        tree.insert(10);
        tree.insert(14);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);
        tree.insert(9);
        tree.insert(11);
        tree.insert(13);
        tree.insert(15);

        System.out.println("inorder");
        tree.inorder();
        System.out.println("preorder");
        tree.preorder();
        System.out.println("postOrder");
        tree.postOrder();
        System.out.println("---isExits---");
        System.out.println(tree.isExits(6));
        System.out.println("---delete---");
        System.out.println(tree.delete(12));
        tree.inorder();


    }
}

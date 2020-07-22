package binarySearchTree;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }

    public BST(E[] object) {
        for (int i = 0; i < object.length; i++)
            insert(object[i]);
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e);
        else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false;
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true;
    }

    @Override
    public int getSize() {
        return size;

    }

    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(TreeNode<E> root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.element + " ");
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    public void preorder(TreeNode<E> root) {
        if (root == null) return;
        System.out.println(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }


    @Override
    public boolean isExits(E e) {
        if (root == null) return false;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;

            } else {
                return true;
            }
        }
        return false;

    }

    protected TreeNode<E> getParent(E e) {
        if (!isExits(e))
            return null;
        TreeNode<E> current = root;
        TreeNode<E> parent = null;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                return parent;
            }
        }
        return null;

    }

    protected TreeNode<E> getElement(E e) {
        if (!isExits(e))
            return null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;

    }

    @Override
    public boolean delete(E e) {
        if (!isExits(e))
            return false;
        if (e.compareTo(root.element) == 0) {
            root = null;
            return true;
        }
        TreeNode<E> parent = getParent(e);
        TreeNode<E> current = getElement(e);
        boolean inLeft = parent.element.compareTo(current.element) > 0;
        boolean inRight = parent.element.compareTo(current.element) < 0;
        boolean bothEmpty = current.right == null && current.left == null;
        boolean leftEmpty = current.left == null;

        TreeNode<E> rightMost = getMaxRight(current);
        TreeNode<E> parentOfRightMost = getParent(rightMost.element);
        TreeNode<E> leftChildOfRightMost = rightMost.left;


        if (bothEmpty) {
            if (inLeft) parent.left = null;
            else if (inRight) parent.right = null;
        } else if (leftEmpty) {
            if (inLeft) {
                parent.left = current.right;
                return true;
            } else if (inRight) {
                parent.right = current.right;
                return true;
            }
        } else {

            if (inLeft) {
                parent.left = rightMost;
                parentOfRightMost.right = leftChildOfRightMost;
                rightMost.left = current.left;
                rightMost.right = current.right;

            } else if (inRight) {
                parent.right = rightMost;
                parentOfRightMost.right = leftChildOfRightMost;
                rightMost.left = current.left;
                rightMost.right = current.right;
                return true;
            }
        }


        return true;
    }

    public TreeNode<E> getMaxRight(TreeNode<E> root) {
        if (root == null) {
            return null;
        }

        TreeNode<E> current = root;
        TreeNode<E> max = root;
        while (current.right != null) {
            max = current.right;
            current = current.right;
        }
        return max;
    }

}
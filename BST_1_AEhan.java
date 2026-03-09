import java.util.ArrayList;
import java.lang.Math;

public class BST_1_AEhan<E extends Comparable<E>> {
    private BSTNode<E> root;
    private class BSTNode<E> {
        private BSTNode<E> left, right;
        private E value;
        public BSTNode(E value) {
            this.value = value;
        }
        public E getValue() {
            return value;
        }
        public BSTNode<E> getLeft() {
            return left;
        }
        public BSTNode<E> getRight() {
            return right;
        }
        public void setLeft(BSTNode<E> node) {
            left = node;
        }
        public void setRight(BSTNode<E> node) {
            right = node;
        }
    }
    public boolean search(E value) {
        if (root == null) {
            return false;
        }
        BSTNode<E> node = root;
        while (node.getLeft() != null || node.getRight() != null) {
            int comparison = node.getValue().compareTo(value);
            if (comparison == 0) {
                return true;
            } else if (comparison < 0 && node.getLeft() != null) {
                node = node.getLeft();
            } else if (comparison > 0 && node.getLeft() != null) {
                node = node.getRight();
            }
        }
        return false;
    }
    public boolean add(E value) {
        if (root == null) {
            root = new BSTNode<E>(value);
            return true;
        }
        BSTNode<E> node = root;
        int comparison = node.getValue().compareTo(value);
        while (node.getLeft() != null || node.getRight() != null) {
            comparison = node.getValue().compareTo(value);
            if (comparison == 0) {
                return false;
            } else if (comparison < 0 && node.getLeft() != null) {
                node = node.getLeft();
            } else if (comparison > 0 && node.getLeft() != null) {
                node = node.getRight();
            }
        }
        if (comparison < 0) {
            node.setLeft(new BSTNode<E>(value));
        } else {
            node.setRight(new BSTNode<E>(value));
        }
        return true;
    }
    public BSTNode<E> getRoot() {
        return root;
    }
    public ArrayList<E> preorder() {
    }
    public ArrayList<E> inorder() {

    }
    public ArrayList<E> postorder() {
    }
    public int height() {
        return height(getRoot());
    }
    public int height(BSTNode<E> subroot) {
        if (subroot == null) {
            return -1;
        }
        return 1 + Math.max(height(subroot.getLeft()), height(subroot.getRight()));
    }
    public int depth(E value) {
        BSTNode<E> current = getRoot();
        int depth = 0;
        while (current != null && current.getValue().compareTo(value) != 0) {
            depth++;
            current = current.getValue().compareTo(value) > 0 ? current.getLeft() : current.getRight();
        }
        return depth;
    }
    public boolean remove(E value) {

    }
}

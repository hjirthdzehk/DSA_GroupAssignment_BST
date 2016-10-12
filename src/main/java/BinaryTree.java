public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;
    private int count;

    public int getHeight(){
        if (root == null) {
            return 0;
        }

        return root.getHeight();
    }

    public void add(T element) {
        count++;
        if (root == null) {
            root = new Node<T>(element, null);
            return;
        }

        addToNode(root, element);
    }

    private void addToNode(Node<T> node, T element){
        if (node.value.compareTo(element) > 0) {
            if (node.getLeft() == null) {
                node.setLeft(new Node<T>(element, node));
            } else {
                addToNode(node.getLeft(), element);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new Node<T>(element, node));
            } else {
                addToNode(node.getRight(), element);
            }
        }
    }

    public boolean remove(T element){
        if (!contains(element)){
            return false;
        }
        removeFrom(root, element);
        return true;
    }

    private void removeFrom(Node<T> node, T element) {
        boolean isLeftNode = node.getParent() == null || node.getParent().getValue().compareTo(node.getValue()) > 0;
        if (node.getValue().compareTo(element) > 0) {
            removeFrom(node.getLeft(), element);
        } else if(node.getValue().compareTo(element) < 0) {
            removeFrom(node.getRight(), element);
        } else {
            if (node.getLeft() == null && node.getRight() == null) {
                if (isLeftNode) {
                    node.getParent().setLeft(null);
                } else {
                    node.getParent().setRight(null);
                }
            } else {
                if (node.getLeft() == null) {
                    if (isLeftNode) {
                        node.getParent().setLeft(node.getRight());
                    } else {
                        node.getParent().setRight(node.getRight());
                    }
                } else if (node.getRight() == null) {
                    if (isLeftNode) {
                        node.getParent().setLeft(node.getLeft());
                    } else {
                        node.getParent().setRight(node.getLeft());
                    }
                } else {
                    Node<T> successor = findSuccesor(node.getRight());
                    successor.getParent().setLeft(null);
                    if (isLeftNode) {
                        node.getParent().setLeft(successor);
                    } else {
                        node.getParent().setRight(successor);
                    }
                    successor.setParent(node.getParent());
                }
            }
        }
    }

    private Node<T> findSuccesor(Node<T> node){
        if (node.getLeft() == null){
            return node;
        } else {
            return findSuccesor(node.getLeft());
        }
    }

    public boolean contains(T element) {
        return containsAtNode(root, element);
    }

    private boolean containsAtNode(Node<T> node, T element){
        if (node == null){
            return false;
        }
        if (node.getValue().equals(element)){
            return true;
        }
        Node<T> nextNode = node.getValue().compareTo(element) > 0
                ? node.getLeft()
                : node.getRight();
        return containsAtNode(nextNode, element);
    }

    public int getCount() {
        return count;
    }

    private class Node<T>{
        private T value;
        private Node<T> left;
        private Node<T> right;
        private Node<T> parent;

        int getHeight(){
            return Math.max(left  != null ? left.getHeight()  : 0
                          , right != null ? right.getHeight() : 0) + 1;
        }

        Node<T> getParent(){
            return parent;
        }

        Node<T> getLeft(){
            return left;
        }

        Node<T> getRight(){
            return right;
        }

        T getValue(){
            return value;
        }

        void setLeft(Node<T> left){
            this.left = left;
        }

        void setRight(Node<T> right){
            this.right = right;
        }

        void setParent(Node<T> parent){
            this.parent = parent;
        }

        Node(T value, Node<T> parent){
            this.value = value;
            this.parent = parent;
        }
    }
}

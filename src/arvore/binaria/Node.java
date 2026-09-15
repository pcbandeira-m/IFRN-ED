package arvore.binaria;

import java.util.Iterator;

public class Node {
    private Node parent;
    private Node leftChild;
    private Node rightChild;
    private Object element;

    public Node(Node parent, Object element) {
        this.parent = parent;
        this.element = element;
    }

    public Node(Node parent, Node leftChild, Node rightChild, Object element) {
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.element = element;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

}

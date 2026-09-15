package arvore.binaria;

import java.util.ArrayList;
import java.util.Iterator;

public class Binary implements InterfaceBinary {
    private Node root;
    private int size;

    public Binary(Node root) {
        this.root = root;
        this.size = 1;
    }

    @Override
    public Node leftChild(Node node) {
        return node.getLeftChild();
    }

    @Override
    public Node rightChild(Node node) {
        return node.getRightChild();
    }

    @Override
    public boolean hasLeftChild(Node node) {
        return leftChild(node) != null;
    }

    @Override
    public boolean hasRightChild(Node node) {
        return rightChild(node) != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int height(Node node) {
        if (node == null || isExternal(node)) return 0;
        else {
            int h = 0;
            ArrayList<Node> children = node.getChildren();
            Iterator<Node> iterator = children.iterator();
            for (iterator.hasNext()) {
                Node child = iterator.next();
                h += 1 + height(child);
            }
            return h;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<Object> elements() {
        return null;
    }

    @Override
    public Iterator<Node> nodes() {
        return null;
    }

    @Override
    public Node root() {
        return root;
    }

    @Override
    public Node parent(Node node) {
        return isRoot(node) ? null : node.getParent();
    }

    @Override
    public Iterator<Node> children(Node node) {
        return null;
    }

    @Override
    public void preOrder(Node node, ArrayList<Object> list) {

    }

    @Override
    public void preOrderNode(Node node, ArrayList<Node> list) {

    }

    @Override
    public boolean isInternal(Node node) {
        return (hasLeftChild(node) || hasRightChild(node));
    }

    @Override
    public boolean isExternal(Node node) {
        return (!hasLeftChild(node) && !hasRightChild(node));
    }

    @Override
    public boolean isRoot(Node node) {
        return node.getParent() == null;
    }

    @Override
    public Integer depth(Node node) {
        return (isRoot(node)) ? 0 : (1 + depth(node.getParent()));
    }

    @Override
    public Object replace(Node node, Object value) {
        return null;
    }

    public Node addLeftChild(Node parent, Object element) {
        if (hasLeftChild(parent)) {
            throw new ExistentNodeException("Already has left child.");
        } else {
            Node lefty = new Node(parent, element);
            parent.setLeftChild(lefty);
            return lefty;
        }
    }

    public Node addRightChild(Node parent, Object element) {
        if (hasRightChild(parent)) {
            throw new ExistentNodeException("Already has right child.");
        } else {
            Node righty = new Node(parent, element);
            parent.setLeftChild(righty);
            return righty;
        }
    }

    @Override
    public void remove(Node node) {
        if (isInternal(node)) {
            throw new IllegalArgumentException("This node isn't able to be removed.");
        }
        if (isRoot(node)) {
            root = null;
            size--;
            return;
        }
        // Se o nó for folha
        Node nodeParent = node.getParent();
        // Se for folha esquerda
        if (nodeParent.getLeftChild() == node) {
            nodeParent.setLeftChild(null);
            node.setParent(null);
            size--;
            return;
        }
        // Se for folha direta
        nodeParent.setRightChild(null);
        node.setParent(null);
        size--;
    }

}
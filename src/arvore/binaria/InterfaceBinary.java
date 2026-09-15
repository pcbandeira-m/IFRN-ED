package arvore.binaria;

import java.util.ArrayList;
import java.util.Iterator;

public interface InterfaceBinary {
    Node leftChild(Node node);
    Node rightChild(Node node);
    boolean hasLeftChild(Node node);
    boolean hasRightChild(Node node);

    // Metodos genericos
    int size();
    int height(Node node);
    boolean isEmpty();
    Iterator<Object> elements();
    Iterator<Node> nodes();

    // Metodos de acesso
    Node root();
    Node parent(Node node);
    Iterator<Node> children(Node node);
    void preOrder(Node node, ArrayList<Object> list);
    void preOrderNode(Node node, ArrayList<Node> list);

    // Metodos de consulta
    boolean isInternal(Node node);
    boolean isExternal(Node node);
    boolean isRoot(Node node);
    Integer depth(Node node);

    // Metodo de atualizaçao
    Object replace(Node node, Object value);
    void remove(Node node);
}

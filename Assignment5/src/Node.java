//author: Usman Khan
//represents the nodes in a binary structures


public class Node {
    Node left;
    Node right;
    Node parent;
    DataItem content;

    // Creates an empty Node
    public Node() {
        this.left = null;
        this.right = null;
        this.parent = null;
        this.content = null;
    }

    // Create a leaf node
    public Node(DataItem content) {
        this.left = null;
        this.right = null;
        this.parent = null;
        this.content = content;
    }

    // Create an internal node with the given children
    public Node(DataItem content, Node left, Node right, Node parent) {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.content = content;
    }

    public Node getLeft() {
        return this.left;
    }
    public Node getRight() {
        return this.right;
    }
    public Node getParent() {
        return this.parent;
    }
    public DataItem getContent() {
        return this.content;
    }

    public boolean isLeaf() {
        if ((this.left == null) && (this.right == null) && (this.content == null))
            return true;
        else
            return false;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }
    public void setContent(DataItem content) {
        this.content = content;
    }
}

//author: Usman Khan


public class BinarySearchTree {
    // BST root node
    Node root;

    // Create an empty BST
    BinarySearchTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node node) {
        root = node;
    }

    public void put(Node newNode) {
        if (root == null) {
            root = newNode;
            return;
        }

        Key newKey = newNode.getContent().getKey();
        Node currNode = root;

        // go through BST
        while (true) {
            Key currNodeKey = currNode.getContent().getKey();

            // if new < curr
            if (newKey.compareTo(currNodeKey) < 0) {
                // if no left child, set new node to be left child
                if (currNode.getLeft().isLeaf()) {
                    currNode.setLeft(newNode);
                    newNode.setParent(currNode);
                    return;
                } else {
                    // if has left child, make current node left child
                    currNode = currNode.getLeft();
                }
            } else { // if new > curr
                // if no right child, set new node to be right child
                if (currNode.getRight().isLeaf()) {
                    currNode.setRight(newNode);
                    newNode.setParent(currNode);
                    return;
                } else {
                    // if has right child, make current node right child
                    currNode = currNode.getRight();
                }
            }
        }
    }

    public Node get(Node node, Key k) {
        if (node == null || node.isLeaf())
            return null;

        Key currKey = node.getContent().getKey();

        if (k.compareTo(currKey) == 0)
            return node;

        if (k.compareTo(currKey) < 0)
            return get(node.getLeft(), k);

        return get(node.getRight(), k);
    }

    public Boolean remove(Node root, Key k) {
        // pos is the node to remove
        Node nodeToRemove = get(root, k);

        if (nodeToRemove.isLeaf())
            return false;

        // pos has an empty left or right child
        if (nodeToRemove.getLeft().isLeaf() || nodeToRemove.getRight().isLeaf()) {
            // get parent of node to remove
            Node top = nodeToRemove.getParent();
            Node nextChild;

            if (nodeToRemove.getLeft().isLeaf()) {
                // if left child empty, next == right
                nextChild = nodeToRemove.getRight();
            }
            else {
                // if right child is empty, next == left
                nextChild = nodeToRemove.getLeft();
            }

            if (nodeToRemove == root) {
                nextChild.setParent(null);
                setRoot(nextChild);
            } else {
                if (top.getRight() == nodeToRemove) {
                    top.setRight(nextChild);
                    nextChild.setParent(top);
                }
                else {
                    top.setLeft(nextChild);
                    nextChild.setParent(top);
                }
            }

            return true;
        } else {
            Node s = smallest(nodeToRemove.getRight());
            nodeToRemove.setContent(s.getContent());

            return remove(s, s.getContent().getKey());
        }
    }

    // Find the smallest key in the tree
    public Node smallest(Node root) {
        if (root.isLeaf()) return null;

        Node pos = root;
        while (!pos.getLeft().isLeaf())
            pos = pos.getLeft();

        return pos;
    }

    // Find the largest key in the tree
    public Node largest(Node root) {
        if (root.isLeaf()) return null;

        Node pos = root;

        while (!pos.getRight().isLeaf())
            pos = pos.getRight();

        return pos;
    }

    // Finds the successor to a key
    public Node successor(Node root, Key k) {
        Node pos = null;
        Node parent;

        if (root.isLeaf())
            return null;

        pos = get(root, k);
        if (!pos.isLeaf() && !pos.getRight().isLeaf())
            return smallest(pos.getRight());

        parent = pos.getParent();

        while (pos != root && parent.getRight() == pos) {
            pos = parent;
            parent = pos.getParent();
        }

        if (pos == root)
            return null;
        else
            return parent;
    }

    // Find the predecessor to a key
    public Node predecessor(Node root, Key k) {
        Node pos = null;
        Node parent;

        if (root.isLeaf())
            return null;

        pos = get(root, k);
        if (pos.getRight() != null && !pos.getLeft().isLeaf())
            return largest(pos.getLeft());

        parent = pos.getParent();
        while (pos != root && parent.getLeft() == pos) {
            pos = parent;
            parent = pos.getParent(); //not sure
        }

        if (pos == root)
            return null;
        else
            return parent;
    }
}








